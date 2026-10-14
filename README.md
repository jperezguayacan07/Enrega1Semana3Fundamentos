# Generación y clasificación de datos

**Asignatura:** Conceptos Fundamentales de Programación  
**Programa:** Java 8 — proyecto de Eclipse

## Descripción

El proyecto genera archivos de entrada de prueba y procesa información de vendedores, productos y ventas. Produce dos reportes CSV: vendedores ordenados por dinero recaudado de mayor a menor y productos vendidos ordenados por cantidad de unidades de mayor a menor.

## Estructura

```text
Entrega1Semana3_ConceptosFundamentales/
├── src/
│   ├── GenerateInfoFiles.java
│   └── main.java
├── data/
│   ├── products.txt
│   ├── salesmen.txt
│   ├── sales_<id>.txt
│   ├── salesmen_report.csv
│   └── products_report.csv
├── README.md
└── conslusion.txt
```

## Cómo ejecutar en Eclipse

1. Importe la carpeta como **Existing Projects into Workspace**.
2. Compruebe que el proyecto utiliza Java 8.
3. Ejecute `GenerateInfoFiles.java` para crear los archivos de entrada en `data/`.
4. Ejecute `main.java` para procesar los archivos y generar los reportes.
5. Revise los CSV en la carpeta `data/`.

Los programas no solicitan datos al usuario. La carpeta de trabajo debe ser la raíz del proyecto para que la ruta relativa `data/` se resuelva correctamente.

## Formato de los archivos

- `products.txt`: `id;nombre;precio`
- `salesmen.txt`: `tipoDocumento;númeroDocumento;nombres;apellidos`
- `sales_<id>.txt`: primera línea `tipoDocumento;númeroDocumento`; líneas siguientes `idProducto;cantidad;`
- `salesmen_report.csv`: `nombre y apellido;dinero recaudado`
- `products_report.csv`: `nombre del producto;precio unitario`

## Validaciones y buenas prácticas

El procesador valida formatos básicos, vendedores y productos inexistentes, cantidades no positivas y precios negativos. El código utiliza métodos separados por responsabilidad, nombres descriptivos, comentarios JavaDoc y cierre automático de archivos con `try-with-resources`.
