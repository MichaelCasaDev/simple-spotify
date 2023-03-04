import type { NextApiRequest, NextApiResponse } from "next";

export default function handler(req: NextApiRequest, res: NextApiResponse) {
  const endpoints = [
    "/api/help",
    "/api/followed_artists",
    "/api/playback",
    "/api/saved_tracks",
    "/api/search?q=%type=",
    "/api/top_tracks",
    "/api/top_artists",
    "/api/auth/login",
    "/api/auth/callback",
    "/api/auth/refresh_token",
  ];
  let a = "";
  endpoints.map((e) => (a += `${process.env.BASE_URI}${e}\n`));
  res.status(200).send(a);
}
