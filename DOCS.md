# Documentazione Simple Spotify

### Struttura progetto
- **[Desktop](desktop)**
- **[Server](server)**

### Links

---

[https://github.com/MichaelCasaDev/simple-spotify](https://github.com/MichaelCasaDev/simple-spotify)

[https://simple-spotify-chi.vercel.app/](https://simple-spotify-chi.vercel.app/)

### Descrizione del Progetto

---

Questo progetto utilizza le API di Spotify per consentire agli utenti di cercare brani, artisti e playlist all'interno della vasta libreria musicale di Spotify. L’applicazione è stata sviluppata utilizzando Java e Node.JS.

Il lato frontend è stato creato utilizzando Java, JAXB per la conversione XML in classi Java, e Java Swing per l'interfaccia grafica. Gli utenti possono cercare canzoni e artisti specifici o esplorare playlist popolari. Inoltre, l'applicazione offre anche la funzionalità di visualizzare i tre artisti più ascoltati dall’utente.

Il lato backend è stato creato utilizzando Node.JS per fornire l'interfaccia web per l'autenticazione OAuth2 verso Spotify. L’applicazione utilizza OAuth2 per l'autenticazione degli utenti, che permette loro di accedere alle API di Spotify.

### Funzionalità

---

Le funzionalità dell'applicazione includono la visualizzazione delle informazioni dell'utente, delle canzoni salvate, dei tre artisti più seguiti, la ricerca di canzoni, artisti e album, e il controllo dello stato della riproduzione su altri dispositivi.

### Endpoints

---

L'applicazione utilizza i seguenti endpoints:

> *https://simple-spotify-chi.vercel.app/api/auth*
> 
- LOGIN - **GET** */login*
- CALLBACK SPOTIFY - **GET** */callback*
- NUOVO TOKEN - **GET** */refresh_token*

> *https://api.spotify.com/v1*
> 
- INFORMAZIONI UTENTE - **GET** /me
- ARTISTI SEGUITI - **GET** /me/following
- TRACCE SALVATE - **GET** /me/tracks
- RICERCA - **GET** /search?q={}&type={artist | track | album}

### Documentazione delle API

---

Di seguito sono riportati i documenti delle API utilizzate dal progetto:

### INFORMAZIONI UTENTE

Questa API restituisce le informazioni dell'utente.

### Richiesta

```
GET /me
```

### Risposta

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<root>
	<images>
		<url>string</url>
	</images>
	<display_name>string</display_name>
	<external_urls>
		<spotify>string</spotify>
	</external_urls>
</root>
```

### ARTISTI SEGUITI

Questa API restituisce gli artisti seguiti dall'utente.

### Richiesta

```
GET /me/following
```

### Risposta

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<root>
	<artists>
		<href>string</href>
		<limit>0</limit>
		<next>string</next>
		<total>0</total>
		<items>
			<external_urls>
				<spotify>string</spotify>
			</external_urls>
			<images>
				<url><https://i.scdn.co/image/ab67616d00001e02ff9ca10b55ce82ae553c8228</url>
			</images>
			<name>string</name>
		</items>
	</artists>
</root>
```

### TRACCE SALVATE

Questa API restituisce le tracce salvate dall'utente.

### Richiesta

```
GET /me/tracks
```

### Risposta

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<root>
  <href>string</href>
  <limit>number</limit>
  <next>string</next>
  <offset>number</offset>
  <previous>string</previous>
  <total>number</total>
  <items>
    <track>
      <external_urls>
        <spotify>string</spotify>
      </external_urls>
      <name>string</name>
      <preview_url>string</preview_url>
    </track>
  </items>
</root>
```

### RICERCA

Questa API restituisce i risultati della ricerca.

### Richiesta

```
GET /search?q={}&type={artist | track | album}
```

### Risposta

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<tracks>
	<items>
		<album>
			<images>
				<height>number</height>
				<url>string</url>
				<width>number</width>
			</images>
		</album>
		<external_urls>
			<spotify>string</spotify>
		</external_urls>
		<name>string</name>
		<preview_url>string</preview_url>
	</items>
	<total>number</total>
</tracks>
```

# License
Project source-code and compiled versions are freely available and licensed under the [GNU General Public License v3.0](LICENSE).
