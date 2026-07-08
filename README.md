## Variables de entorno

El proyecto utiliza las siguientes variables de entorno:

| Variable | Descripción | Valor por defecto |
|----------|-------------|-------------------|
| `WEATHER_API_URL` | URL base de WeatherAPI | `https://api.weatherapi.com/v1` |
| `WEATHER_API_KEY` | API Key de WeatherAPI | - |
| `WEATHER_API_LOCATION` | Ubicación a consultar (nombre de ciudad o coordenadas) | `-34.6037,-58.3816` |
| `MAIL_USERNAME` | Cuenta de Gmail utilizada para enviar alertas | - |
| `MAIL_PASSWORD` | Contraseña de aplicación de Gmail | - |
| `ALERTA_EMAIL_DESTINO` | Correo destinatario de las alertas | - |
| `TEMPERATURA_CRITICA` | Temperatura mínima para generar una alerta | `35` |
| `HUMEDAD_CRITICA` | Humedad mínima para generar una alerta | `60` |
| `INTERVALO_CONSULTA_CLIMA` | Intervalo de consulta a WeatherAPI (milisegundos) | `300000` (5 minutos) |
| `INTERVALO_ANALISIS_ALERTAS` | Intervalo de análisis de alertas (milisegundos) | `60000` (1 minuto) |

### Ejemplo

```text
WEATHER_API_URL=https://api.weatherapi.com/v1
WEATHER_API_KEY=xxxxxxxxxxxxxxxx
WEATHER_API_LOCATION=-34.6037,-58.3816

MAIL_USERNAME=climalert@gmail.com
MAIL_PASSWORD=abcdefghijklmnop
ALERTA_EMAIL_DESTINO=destino@gmail.com

TEMPERATURA_CRITICA=35
HUMEDAD_CRITICA=60

INTERVALO_CONSULTA_CLIMA=300000
INTERVALO_ANALISIS_ALERTAS=60000
```
