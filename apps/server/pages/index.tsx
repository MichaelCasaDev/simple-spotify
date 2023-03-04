import $ from "jquery";
import Head from "next/head";
import Link from "next/link";
import { useRouter } from "next/router";
import { useEffect, useState } from "react";

export default function Home() {
  const [render, setRender] = useState(false);
  const [userProfile, setUserProfile] = useState(null as any);
  const [access_token, setAccess_token] = useState("");
  const [refresh_token, setRefresh_token] = useState("");
  const router = useRouter();

  useEffect(() => {
    setRender(true);

    const params = getHashParams();
    setAccess_token(params.access_token);
    setRefresh_token(params.refresh_token);

    if (params.access_token) {
      $.ajax({
        url: "https://api.spotify.com/v1/me",
        headers: {
          Authorization: "Bearer " + params.access_token,
        },
        success: function (response) {
          setUserProfile(response);

          $("#login").hide();
          $("#loggedin").show();
        },
      });
    } else {
      $("#login").show();
      $("#loggedin").hide();
    }
  }, []);
  if (!render) return null;

  function getHashParams() {
    var hashParams: any = {};
    var e,
      r = /([^&;=]+)=?([^&;]*)/g,
      q = router.asPath.substring(2);
    while ((e = r.exec(q))) {
      hashParams[e[1]] = decodeURIComponent(e[2]);
    }

    return hashParams;
  }

  return (
    <>
      <Head>
        <title>Sinple Spotify</title>
      </Head>

      <body>
        <div id="login">
          <div id="container">
            <img src="/logo-no-background.svg" height="64px" />
            <Link href="/api/auth/login" className="btn btn-primary">
              Accedi con Spotify
            </Link>
          </div>
        </div>

        <div id="loggedin">
          <div id="container">
            <img src="/logo-no-background.svg" height="32px" />
            {access_token ? (
              <>
                <div id="user-profile">
                  <h1>Accesso effettuato come {userProfile?.display_name}</h1>
                  <img
                    className="media-object user-pic"
                    width="256px"
                    src={userProfile?.images[0].url}
                  />
                </div>
                <div id="oauth">
                  <h2>Client Token</h2>
                  <p id="acc_token">{access_token}</p>
                </div>
              </>
            ) : (
              <>
                <div id="user-profile"></div>
                <div id="oauth"></div>
              </>
            )}
            <div id="buttons">
              <button
                className="btn btn-default"
                id="copy-token"
                onClick={() => {
                  let copyFrom = document.createElement("textarea");
                  document.body.appendChild(copyFrom);
                  copyFrom.textContent = access_token;
                  copyFrom.select();
                  document.execCommand("copy");
                  copyFrom.remove();

                  alert("Token copiato con successo!");
                }}
              >
                Copia token
              </button>
              <button
                className="btn btn-default"
                id="obtain-new-token"
                onClick={() => {
                  $.ajax({
                    url: "/api/auth/refresh_token",
                    data: {
                      refresh_token: refresh_token,
                    },
                  }).done(function (data) {
                    setAccess_token(data.access_token);
                  });
                }}
              >
                Richiedi nuovo token
              </button>
            </div>
          </div>
        </div>
      </body>
    </>
  );
}
