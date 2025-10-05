package com.example.pdf_con_tablas;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    Button botonGenerar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Debés tener un botón en tu layout con id "botonGenerar"

        botonGenerar = findViewById(R.id.botonGenerar);

        botonGenerar.setOnClickListener(v -> crearPDF());
    }

    private void crearPDF() {
        // 1. Crear documento PDF
        PdfDocument documento = new PdfDocument();
        PdfDocument.PageInfo infoPagina = new PdfDocument.PageInfo.Builder(595, 842, 1).create(); // A4
        PdfDocument.Page pagina = documento.startPage(infoPagina);

        Canvas canvas = pagina.getCanvas();
        Paint paint = new Paint();

        // 2. Dibujar logo (asegurate de tener logo en res/drawable/logo.png)
        Bitmap logo = BitmapFactory.decodeResource(getResources(), R.drawable.logo);
        Bitmap logoEscalado = Bitmap.createScaledBitmap(logo, 80, 80, true);
        canvas.drawBitmap(logoEscalado, 40, 40, paint);

        // 3. Dibujar título
        paint.setTextSize(18);
        paint.setColor(Color.BLACK);
        paint.setFakeBoldText(true);
        canvas.drawText("Lista de productos", 160, 80, paint);

        // 4. Datos para la tabla
        String[][] productos = {
                {"Producto", "Precio", "Descuento"},
                {"Coca Cola", "$1500", "10%"},
                {"Pepsi", "$1400", "15%"},
                {"Fanta", "$1300", "5%"},
                {"Sprite", "$1200", "0%"}
        };

        // 5. Dimensiones de la tabla
        int startX = 40;
        int startY = 160;
        int rowHeight = 40;

        int col1Width = 250;
        int col2Width = 130;
        int col3Width = 130;

        paint.setTextSize(14);
        paint.setFakeBoldText(false);

        // 6. Dibujar tabla
        for (int i = 0; i < productos.length; i++) {
            int currentY = startY + i * rowHeight;
            canvas.drawText(productos[i][0], startX, currentY, paint);
            canvas.drawText(productos[i][1], startX + col1Width, currentY, paint);
            canvas.drawText(productos[i][2], startX + col1Width + col2Width, currentY, paint);
        }

        documento.finishPage(pagina);

        // 7. Guardar archivo según versión de Android
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            // Android 10+: usar MediaStore
            ContentValues contentValues = new ContentValues();
            contentValues.put(MediaStore.Downloads.DISPLAY_NAME, "productos.pdf");
            contentValues.put(MediaStore.Downloads.MIME_TYPE, "application/pdf");
            contentValues.put(MediaStore.Downloads.IS_PENDING, 1);

            ContentResolver resolver = getContentResolver();
            Uri uri = resolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues);

            try {
                OutputStream outputStream = resolver.openOutputStream(uri);
                documento.writeTo(outputStream);
                outputStream.close();

                contentValues.clear();
                contentValues.put(MediaStore.Downloads.IS_PENDING, 0);
                resolver.update(uri, contentValues, null, null);

                Toast.makeText(this, "PDF guardado (Android 10+)", Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        } else {
            // Android 9 o menor: verificar permiso y guardar en carpeta Downloads
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                return;
            }

            File carpeta = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File archivo = new File(carpeta, "productos.pdf");

            try {
                FileOutputStream fos = new FileOutputStream(archivo);
                documento.writeTo(fos);
                fos.close();
                Toast.makeText(this, "PDF guardado en Descargas (Android 9 o menos)", Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }

        documento.close();
    }
}
