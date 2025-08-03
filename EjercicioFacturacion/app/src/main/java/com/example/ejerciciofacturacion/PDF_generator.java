package com.example.ejerciciofacturacion;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class PDF_generator extends AppCompatActivity {

    private Button botonGenerar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facturar); // carga el layout con el botón

        // Asociamos el botón con su ID en el XML
        botonGenerar = findViewById(R.id.facturame);

        // Cuando el botón se presiona...
        botonGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llamamos a la función para crear el PDF con este texto
                crearPDF("C");
            }
        });
    }


    // Metodo para generar el pdf
    private void crearPDF(String texto) {
        String original = "ORIGINAL";
        String factura = "FACTURA";
        String fecha_emision = "Fecha de emision";
        String Cuit= "Cuit";
        String Comprobante= "Comprobante";
        String Inicio_Actividades= "Inicio Actividades";


        String inscripcion_ingresos_brutos = "Inscripción Ingresos Brutos";
        String razon_social = "Razón Social";
        String domicilio = "Domicilio";
        String telefono = "Teléfono";
        String condicion_iva = "Condición frente al IVA";

        String codigo = "Codigo";
        String nombre = "Nombre";
        String precio = "Precio";
        String cantidad = "Cantidad";
        String descuento = "Descuento";
        String subtotal = "Subtotal";

        String subtotaldescuento = "Subtotal Desc";
        String precio1 = "$";
        String precio2 = "$";
        String total = "Total";




        // 1. Creamos un nuevo documento PDF
        PdfDocument documento = new PdfDocument();

        // 2. Definimos las características de la página: tamaño A4 (595x842 puntos), página 1
        PdfDocument.PageInfo infoPagina = new PdfDocument.PageInfo.Builder(595, 842, 1).create();

        // 3. Iniciamos la creación de una página dentro del documento con la configuración definida
        PdfDocument.Page pagina = documento.startPage(infoPagina);

        // 4. Obtenemos el lienzo (canvas) para dibujar dentro de la página
        Canvas canvas = pagina.getCanvas();

        // 5. Creamos una herramienta de dibujo para el texto (Paint)
        Paint paint = new Paint();
        Paint Cuadrado = new Paint();
        Paint categoria = new Paint();

        // 6. Definimos el tamaño del texto que vamos a dibujar
        paint.setTextSize(12);
        categoria.setTextSize(36);
        Cuadrado.setStyle(Paint.Style.STROKE);

        // 7. Dibujamos el texto recibido como parámetro en la posición (x=80, y=100)

        canvas.drawText(texto, 295, 150,categoria); //C
        canvas.drawText(original, 506, 210, paint); //original


        //sector derecho
        canvas.drawText(factura, 400, 118, paint);
        canvas.drawText(fecha_emision, 300, 230, paint);
        canvas.drawText(Comprobante, 300, 260, paint);
        canvas.drawText(Cuit, 300, 290, paint);
        canvas.drawText(Inicio_Actividades, 300, 320, paint);
        canvas.drawText(inscripcion_ingresos_brutos, 300, 340, paint);

        //sector izquierdo
        canvas.drawText(razon_social, 0, 230, paint);
        canvas.drawText(domicilio, 0, 260, paint);
        canvas.drawText(telefono, 0, 290, paint);
        canvas.drawText(condicion_iva, 0, 320, paint);

        //leyendas
        canvas.drawText(codigo, 0, 418, paint);
        canvas.drawText(nombre, 127, 418, paint);
        canvas.drawText(precio, 290, 418, paint);
        canvas.drawText(cantidad, 366, 418, paint);
        canvas.drawText(descuento, 441, 418, paint);
        canvas.drawText(subtotal, 520, 418, paint);

        //totales
        canvas.drawText(subtotaldescuento, 280, 800, paint);
        canvas.drawText(precio1, 366, 800, paint);
        canvas.drawText(total, 456, 800, paint);
        canvas.drawText(precio2, 521, 800, paint);




        //verticales
        canvas.drawLine(0,400,595,400,paint);
        canvas.drawLine(0,438,595,438,paint);
        canvas.drawLine(0,782,595,782,paint);
        canvas.drawLine(0,842,595,842,paint);
        //horizontales
        canvas.drawLine(40,842,40,400,paint);
        canvas.drawLine(280,842,280,400,paint);
        canvas.drawLine(360,842,360,400,paint);
        canvas.drawLine(440,842,440,400,paint);
        canvas.drawLine(520,842,520,400,paint);
        canvas.drawLine(300,400,300,400,paint);
        canvas.drawRect(260, 103, 340, 183, Cuadrado);




        // 8. Terminamos la edición de la página actual para agregarla al documento
        documento.finishPage(pagina);

        // 9. Detectamos la versión del sistema operativo para decidir cómo guardar el archivo
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            // Para Android 10 o superior (API 29+), usamos MediaStore para guardar el archivo
            ContentValues contentValues = new ContentValues();
            contentValues.put(MediaStore.Downloads.DISPLAY_NAME, "documento_generado.pdf"); // Nombre del archivo
            contentValues.put(MediaStore.Downloads.MIME_TYPE, "application/pdf");           // Tipo MIME PDF
            contentValues.put(MediaStore.Downloads.IS_PENDING, 1);                           // Marcamos el archivo como pendiente para escribirlo

            // Obtenemos el ContentResolver para interactuar con el almacenamiento
            ContentResolver resolver = getContentResolver();

            // Insertamos un nuevo registro en MediaStore para el archivo PDF
            Uri uri = resolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues);

            try {
                // Abrimos un flujo de salida para escribir el contenido del PDF en el URI obtenido
                OutputStream outputStream = resolver.openOutputStream(uri);

                // Escribimos el documento PDF en el flujo
                documento.writeTo(outputStream);

                // Cerramos el flujo para finalizar la escritura
                outputStream.close();

                // Actualizamos el estado del archivo a no pendiente para hacerlo visible
                contentValues.clear();
                contentValues.put(MediaStore.Downloads.IS_PENDING, 0);
                resolver.update(uri, contentValues, null, null);

                // Mostramos mensaje de éxito al usuario
                Toast.makeText(this, "PDF guardado en Downloads (Android 10+)", Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                // En caso de error, mostramos mensaje con el detalle
                Toast.makeText(this, "Error al guardar PDF: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }

        } else {
            // Para Android 9 o inferior (API < 29), guardamos directamente en carpeta pública Downloads
            // Primero verificamos si tenemos permiso para escribir en almacenamiento externo
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                // Si no tenemos permiso, lo solicitamos y salimos para esperar la respuesta del usuario
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                return; // Salimos para esperar la respuesta del permiso
            }

            // Obtenemos la carpeta pública "Downloads"
            File carpeta = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

            // Definimos el archivo donde se guardará el PDF
            File archivo = new File(carpeta, "documento_generado.pdf");

            try {
                // Abrimos un flujo para escribir en el archivo definido
                FileOutputStream fos = new FileOutputStream(archivo);

                // Escribimos el documento PDF en el archivo
                documento.writeTo(fos);

                // Cerramos el flujo
                fos.close();

                // Mensaje de éxito para el usuario
                Toast.makeText(this, "PDF guardado en Downloads (Android 9 o menor)", Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                // Mensaje de error si algo sale mal
                Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }

        // 10. Cerramos el documento para liberar recursos
        documento.close();
    }


}
