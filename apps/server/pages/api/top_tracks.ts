import type { NextApiRequest, NextApiResponse } from "next";
import { get } from "request";
import { toXml } from "xml2json";

export default async function handler(
  req: NextApiRequest,
  res: NextApiResponse
) {
  const searchOptions = {
    url: `https://api.spotify.com/v1/me/top/tracks`,
    headers: {
      Authorization: `Bearer ${req.headers["access-token"]}`,
    },
    json: true,
  };

  get(searchOptions, (error, response, body) => {
    if (!error && response.statusCode === 200) {
      res.send(toXml(body));
    } else {
      res.send("Error!");
    }
  });
}
