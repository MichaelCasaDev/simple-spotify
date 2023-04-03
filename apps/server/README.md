# Simple Spotify | Server

1. Get the neccessary credentials from [Spotify Developer Dashboard](https://developer.spotify.com/dashboard)
2. Compile the `.ENV` file, you have a example file of it
3. Start the web server using `npm run dev`

### File .ENV
```env
CLIENT_ID=<client id from Spotify>
CLIENT_SECRET=<client secret from Spotify>
REDIRECT_URI=<redirect uri based on the domain of your web server>/api/auth/callback
BASE_URI=<base uri from your domain of web service>
```

# License
Project source-code and compiled versions are freely available and licensed under the [GNU General Public License v3.0](../../LICENSE).
