import type { NextApiRequest, NextApiResponse } from "next";
import { post } from "request";
import { stringify } from "querystring";

export default function handler(req: NextApiRequest, res: NextApiResponse) {
  const client_id = process.env.CLIENT_ID;
  const client_secret = process.env.CLIENT_SECRET;
  const redirect_uri = process.env.REDIRECT_URI;

  const code = req.query.code || null;

  const authOptions = {
    url: "https://accounts.spotify.com/api/token",
    form: {
      code: code,
      redirect_uri: redirect_uri,
      grant_type: "authorization_code",
    },
    headers: {
      Authorization: `Basic  ${new Buffer(
        client_id + ":" + client_secret
      ).toString("base64")}`,
    },
    json: true,
  };

  post(authOptions, (error, response, body) => {
    if (!error && response.statusCode === 200) {
      const access_token = body.access_token;
      const refresh_token = body.refresh_token;

      res.redirect(
        "/#" +
          stringify({
            access_token: access_token,
            refresh_token: refresh_token,
          })
      );
    } else {
      res.redirect(
        "/#" +
          stringify({
            error: "invalid_token",
          })
      );
    }
  });
}
