# 🚀 Proyecto de Mejora de Calidad de Código con JaCoCo

Este proyecto demuestra el proceso completo de refactorización y mejora de calidad de código utilizando JaCoCo como herramienta de análisis de cobertura.

## 📋 Contexto del Proyecto

Durante el desarrollo de un sistema de gestión de pedidos, me encontré con varios problemas de calidad que afectaban la mantenibilidad del código:

- **Strings mágicos** por todas partes ("VIP", "REGULAR")
- **Números sin explicación** (0.2, 0.1, 500, 20)
- **Falta de validación** en los parámetros de entrada
- **Código con múltiples responsabilidades** en un solo método
- **Pruebas insuficientes** que no cubrían casos límite

Decidí aplicar un proceso estructurado de mejora usando JaCoCo para medir objetivamente el progreso.

## 🎯 Objetivos Alcanzados

### Métricas de Mejora
- **Cobertura de pruebas**: 65% → 78% (+13%)
- **Número de pruebas**: 4 → 36 (+900%)
- **Clases con pruebas**: 1 → 3
- **Instrucciones cubiertas**: 39 → 125

### Cambios Principales

#### 1. Eliminación de Strings Mágicos
```java
// Antes: Error esperando pasar
if (tipoCliente.equals("VIP")) {
    total = total - (total * 0.2);
}

// Después: Type-safe y mantenible
TipoCliente tipo = TipoCliente.fromString(tipoCliente);
double descuento = subtotal * tipo.getDescuento();
```

#### 2. Separación de Responsabilidades
Creé clases especializadas:
- **`TipoCliente`**: Enum con validación incorporada
- **`DescuentosConstants`**: Centralización de valores
- **`PedidoValidator`**: Lógica de validación separada
- **`PedidoService`**: Servicio con métodos pequeños y claros

#### 3. Pruebas Completas
Agregué pruebas para todos los escenarios:
- Casos normales (VIP, Regular, sin descuento)
- Casos límite (ceros, valores mínimos)
- Validación de errores (valores negativos)
- Escenarios complejos (descuentos combinados)

## 🏗️ Estructura del Proyecto

```
calidad-codigo-jacoco/
├── src/main/java/vallegrande/edu/pe/
│   ├── constants/
│   │   └── DescuentosConstants.java
│   ├── model/
│   │   └── TipoCliente.java
│   ├── service/
│   │   └── PedidoService.java
│   ├── validator/
│   │   └── PedidoValidator.java
│   └── Main.java
├── src/test/java/
│   ├── service/PedidoServiceTest.java
│   ├── model/TipoClienteTest.java
│   └── validator/PedidoValidatorTest.java
└── target/site/jacoco/
    └── index.html (reporte de cobertura)
```

## 🛠️ Tecnologías Utilizadas

- **Java 17** - Lenguaje principal
- **Maven** - Gestión de dependencias
- **JUnit 5** - Framework de pruebas
- **JaCoCo** - Análisis de cobertura

## 📊 Reporte de Cobertura

El reporte completo de JaCoCo se genera automáticamente al ejecutar las pruebas:

```bash
mvn clean test jacoco:report
```

Puedes ver el reporte en: `target/site/jacoco/index.html`

## 🧪 Ejecutar las Pruebas

```bash
# Clonar el repositorio
git clone <repositorio>
cd calidad-codigo-jacoco

# Ejecutar todas las pruebas
mvn test

# Generar reporte de cobertura
mvn jacoco:report
```

## 📈 Lecciones Aprendidas

### Lo que funcionó bien:
1. **JaCoCo fue fundamental** para identificar objetivamente las áreas de mejora
2. **La separación de responsabilidades** hizo el código mucho más testable
3. **Los enums eliminaron errores** relacionados con strings mágicos
4. **Las pruebas exhaustivas** dieron confianza para futuros cambios

### Desafíos encontrados:
1. **Reestructurar código existente** sin romper funcionalidad
2. **Equilibrar granularidad** de los métodos sin sobre-ingeniería
3. **Mantener compatibilidad** mientras se refactoriza

## 🎓 Conclusión

Este proyecto demostró que es posible mejorar significativamente la calidad del código de forma sistemática. La clave fue:

1. **Medir primero** (JaCoCo mostró exactamente dónde mejorar)
2. **Refactorizar incrementalmente** (un cambio a la vez)
3. **Validar con pruebas** (cada cambio mantuvo la funcionalidad)

El resultado es un código más robusto, mantenible y fácil de extender - exactamente lo que necesito para desarrollar con confianza.

---

**Autor**: [Tu Nombre]  
**Curso**: Programación de Sistemas Web  
**Institución**: Valle Grande