import type { NextApiRequest, NextApiResponse } from "next";
import { stringify } from "querystring";

export default function handler(req: NextApiRequest, res: NextApiResponse) {
  const client_id = process.env.CLIENT_ID;
  const redirect_uri = process.env.REDIRECT_URI;

  const scope =
    "user-read-private user-library-read user-read-playback-position user-read-currently-playing user-read-playback-state user-modify-playback-state user-follow-read";

  res.redirect(
    "https://accounts.spotify.com/authorize?" +
      stringify({
        response_type: "code",
        client_id: client_id,
        scope: scope,
        redirect_uri: redirect_uri,
      })
  );
}
