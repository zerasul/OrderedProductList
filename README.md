# Prueba técnica Productos Ordenados

[![Java CI with Maven](https://github.com/zerasul/OrderedProductList/actions/workflows/maven.yml/badge.svg)](https://github.com/zerasul/OrderedProductList/actions/workflows/maven.yml)

En este repositorio, puedes encontrar una aplicación de ejemplo con una resolución a una prueba técnica, para devolver un listado de productos ordenados por varios criterios.

En esta aplicación basada en Spring Boot despliega una API REST, que recibe una lista de criterios con un peso en cada uno.

Estos criterios permitirán calcular para cada producto una puntuación (scrore) que será por la que se ordene de forma descendente.

Para acceder a esta API, puede hacerlo de la siguiente forma:

```
POST http://localhost:8091/api/products/criteria/ 
```

Que recibe los siguientes Datos:

```json
[{
  "name": "salesUnit",
  "weight": "2",
  "column": "salesUnits"
},
  {
    "name": "stockratio",
    "weight": "3",
    "column": "stockRatio"
  }
]
```

Con respecto al peso, se realizará una suma ponderada de cada columna establecida con su peso. 

Esta api devolverá el listado ya ordenado.

## Arrancar la aplicación

Para arrancar la aplicación, puede usarse el fichero ```docker-compose.yml```. Puede seguir los siguientes pasos:

1. Compilar y generar el Jar con Maven:

```bash
mvn clean package
```

2. Construir la Imagen

```bash
docker-compose build
```

**NOTA:** Consulte el fichero .env para ver las variables de entorno necesarias.

3. Arrancar la aplicación

```bash
docker-compose up
```

Se arrancará una instancia de Mysql y la propia aplicación.

**NOTA:** En el directorio _data_, hay un script sql por si quiere insertar datos de ejemplo.

También puede usar los tests de integración, usando un contenedor Mysql (Que se arranca automáticamente el iniciar los tests) para probar la aplicación. 

Para lanzar los tests:

```bash
mvn clean test
```
