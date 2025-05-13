# Conversor de Monedas con Interfaz Gráfica (Swing)

Este proyecto es un conversor de monedas que utiliza la API de `ExchangeRate-API` para obtener las tasas de cambio en tiempo real. La aplicación tiene una interfaz gráfica de usuario (GUI) creada con Java Swing, lo que permite al usuario seleccionar monedas de origen y destino, ingresar el monto y obtener la conversión instantánea.

## Requisitos

- **Java 11 o superior**.
- **Maven** para gestionar dependencias.

## Dependencias

Este proyecto utiliza la librería **Gson** para parsear las respuestas JSON de la API. La dependencia de Gson está definida en el archivo `pom.xml`.

## Instrucciones

1. **Clonar o descargar el proyecto:**

   Si usas Git, puedes clonar el repositorio con el siguiente comando:
   
   ```bash
   git clone https://github.com/briansastre-ops/ConversorDeMonedas.git
Abrir el proyecto en IntelliJ o NetBeans:

Si usas IntelliJ IDEA:

Abre IntelliJ IDEA.

Selecciona Open y elige la carpeta donde descargaste el proyecto.

IntelliJ reconocerá automáticamente el archivo pom.xml y descargará las dependencias necesarias.

Si usas NetBeans:

Abre NetBeans.

Selecciona File > Open Project y elige la carpeta donde descargaste el proyecto.

Compilar y ejecutar el proyecto:

En IntelliJ o NetBeans, simplemente haz clic en Run para compilar y ejecutar el programa.

Uso de la aplicación:

Al ejecutar el programa, se abrirá una ventana donde podrás:

Seleccionar la moneda de origen (por ejemplo, USD).

Seleccionar la moneda de destino (por ejemplo, ARS).

Ingresar el monto que deseas convertir.

Hacer clic en el botón Convertir.

El resultado de la conversión se mostrará en la etiqueta Resultado.



ConversorMonedasGUI/

├── pom.xml                   # Archivo de configuración de Maven

└── src/
   
    └── org/
       
        └── example/
           
            └── ConversorGUI.java   # Código fuente principal del conversor
