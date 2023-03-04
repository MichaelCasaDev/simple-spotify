import type { NextApiRequest, NextApiResponse } from "next";

export default function handler(req: NextApiRequest, res: NextApiResponse) {
  res
    .status(200)
    .send(`404 API endpoint not found\nTry ${process.env.BASE_URI}/api/help`);
}
