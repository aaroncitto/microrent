# MicroRent: Arquitectura Backend de Plataforma de Alojamientos

## Resumen Ejecutivo
MicroRent es el motor backend de una plataforma de gestión de alojamientos y reservas. El sistema está diseñado para soportar alta concurrencia en consultas de disponibilidad y gestión de reservas, utilizando una arquitectura robusta basada en el ecosistema Spring y bases de datos NoSQL.

## Stack Tecnológico
*   **Core Backend:** Java, Spring Boot (Web, Data MongoDB).
*   **Base de Datos:** MongoDB.
*   **Arquitectura:** API RESTful orientada a servicios.

## 1. Decisiones de Arquitectura y Base de Datos
Se implementó **MongoDB** (base de datos orientada a documentos) en lugar de un modelo relacional tradicional (SQL). Esta decisión técnica se tomó para maximizar la flexibilidad en la gestión de esquemas de datos heterogéneos (por ejemplo, alojamientos con diferentes atributos, reglas de la casa y *amenities*) y para optimizar los tiempos de lectura en las búsquedas masivas del catálogo.

### Colecciones Principales
El sistema se sostiene sobre tres pilares de datos interconectados lógicamente en la capa de servicio:
*   **`Users`:** Gestión de perfiles, credenciales y definición de roles (Huésped / Anfitrión).
*   **`Properties`:** Almacenamiento de los alojamientos, ubicación, tarifas dinámicas, características variables y disponibilidad general.
*   **`Reservations`:** Motor que vincula usuarios y propiedades. Gestiona el ciclo de vida de la reserva (Pendiente, Confirmada, Cancelada) y actúa como fuente de verdad para los bloqueos de calendario.

## 2. Lógica de Negocio Destacada
*   **Motor de Disponibilidad:** Implementación de validaciones a nivel de servicio para prevenir colisiones y *overbooking*. El sistema cruza las fechas solicitadas contra la colección `Reservations` antes de emitir la confirmación.
*   **Patrón de Diseño:** Separación estricta de responsabilidades en capas (Controllers, Services, Repositories), garantizando un bajo acoplamiento y preparando el sistema para una futura escalabilidad.
