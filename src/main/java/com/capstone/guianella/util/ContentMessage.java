package com.capstone.guianella.util;

public class ContentMessage {

    public static String resPassHTML(String resetPassURL, String request) {

        String contenido2 = "<!DOCTYPE html>\n" +
                "<html\n" +
                "  lang=\"en\"\n" +
                "  xmlns=\"http://www.w3.org/1999/xhtml\"\n" +
                "  xmlns:v=\"urn:schemas-microsoft-com:vml\"\n" +
                "  xmlns:o=\"urn:schemas-microsoft-com:office:office\"\n" +
                ">\n" +
                "  <head>\n" +
                "    \n" +
                "    <meta content=\"text/html\" charset=\"utf-8\" />\n" +
                "    <meta name=\"viewport\" content=\"width=device-width\" />\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
                "    <meta name=\"x-apple-disable-message-reformatting\" />\n" +
                "    <title></title>\n" +
                "\n" +
                "    <link\n" +
                "      href=\"https://fonts.googleapis.com/css?family=Roboto:400,600\"\n" +
                "      rel=\"stylesheet\"\n" +
                "      type=\"text/css\"\n" +
                "    />\n" +
                "    <style>\n" +
                "      html,\n" +
                "      body {\n" +
                "        margin: 0 auto !important;\n" +
                "        padding: 0 !important;\n" +
                "        height: 100% !important;\n" +
                "        width: 100% !important;\n" +
                "        font-family: \"Roboto\", sans-serif !important;\n" +
                "        font-size: 14px;\n" +
                "        margin-bottom: 10px;\n" +
                "        line-height: 24px;\n" +
                "        color: #29333d;\n" +
                "        font-weight: 400;\n" +
                "      }\n" +
                "      * {\n" +
                "        -ms-text-size-adjust: 100%;\n" +
                "        -webkit-text-size-adjust: 100%;\n" +
                "        margin: 0;\n" +
                "        padding: 0;\n" +
                "      }\n" +
                "      table,\n" +
                "      td {\n" +
                "        mso-table-lspace: 0pt !important;\n" +
                "        mso-table-rspace: 0pt !important;\n" +
                "      }\n" +
                "      table {\n" +
                "        border-spacing: 0 !important;\n" +
                "        border-collapse: collapse !important;\n" +
                "        table-layout: fixed !important;\n" +
                "        margin: 0 auto !important;\n" +
                "      }\n" +
                "      table table table {\n" +
                "        table-layout: auto;\n" +
                "      }\n" +
                "      a {\n" +
                "        text-decoration: none;\n" +
                "      }\n" +
                "      img {\n" +
                "        -ms-interpolation-mode: bicubic;\n" +
                "      }\n" +
                "    </style>\n" +
                "  </head>\n" +
                "\n" +
                "  <body\n" +
                "    width=\"100%\"\n" +
                "    style=\"\n" +
                "      margin: 0;\n" +
                "      padding: 0 !important;\n" +
                "      mso-line-height-rule: exactly;\n" +
                "      background-color: #aeb9bb;\n" +
                "    \"\n" +
                "  >\n" +
                "    <center style=\"width: 100%; background-color: #aeb9bb\">\n" +
                "      <table\n" +
                "        width=\"100%\"\n" +
                "        border=\"0\"\n" +
                "        cellpadding=\"0\"\n" +
                "        cellspacing=\"0\"\n" +
                "        bgcolor=\"#aeb9bb\"\n" +
                "      >\n" +
                "        <tr>\n" +
                "          <td style=\"padding: 40px 0\">\n" +
                "            <table style=\"width: 100%; max-width: 620px; margin: 0 auto\">\n" +
                "              <tbody>\n" +
                "                <tr>\n" +
                "                  <td style=\"text-align: center\">\n" +
                "                    <a href=\"#\"\n" +
                "                      ><img\n" +
                "                        style=\"height: 150px\"\n" +
                "                        src=\"https://res.cloudinary.com/dolhmjhkc/image/upload/v1696020499/Guianella/logo_Guianella_ovognc.png\"\n"
                +
                "                        alt=\"logo\"\n" +
                "                    /></a>\n" +
                "                  </td>\n" +
                "                </tr>\n" +
                "              </tbody>\n" +
                "            </table>\n" +
                "            <table\n" +
                "              style=\"\n" +
                "                width: 100%;\n" +
                "                max-width: 620px;\n" +
                "                margin: 0 auto;\n" +
                "                background-color: #e5e5e5;\n" +
                "              \"\n" +
                "            >\n" +
                "              <tbody>\n" +
                "                <tr>\n" +
                "                  <td style=\"text-align: center; padding: 30px 30px 15px 30px\">\n" +
                "                    <h2\n" +
                "                      style=\"\n" +
                "                        font-size: 18px;\n" +
                "                        color: #423431;\n" +
                "                        font-weight: 600;\n" +
                "                        margin: 0;\n" +
                "                      \"\n" +
                "                    >\n" +
                "                      Reset Password\n" +
                "                    </h2>\n" +
                "                  </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                  <td style=\"text-align: center; padding: 0 30px 20px\">\n" +
                "                    <p style=\"margin-bottom: 10px\">Hi Sundar,</p>\n" +
                "                    <p style=\"margin-bottom: 25px\">\n" +
                "                      Haga clic en el enlace para restablecer la contraseña del usuario..\n" +
                "                    </p>\n" +
                "                    <a\n" +
                "                      href=\"[[URL]]\"\n" +
                "                      style=\"\n" +
                "                        background-color: #423431;\n" +
                "                        border-radius: 4px;\n" +
                "                        color: #ffffff;\n" +
                "                        display: inline-block;\n" +
                "                        font-size: 13px;\n" +
                "                        font-weight: 600;\n" +
                "                        line-height: 44px;\n" +
                "                        text-align: center;\n" +
                "                        text-decoration: none;\n" +
                "                        text-transform: uppercase;\n" +
                "                        padding: 0 25px;\n" +
                "                      \"\n" +
                "                      >Restablecer Contraseña</a\n" +
                "                    >\n" +
                "                  </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                  <td style=\"text-align: center; padding: 20px 30px 40px\">\n" +
                "                    <p>\n" +
                "                      Si no realizó esta solicitud, contáctenos o ignore este\n" +
                "                      mensaje.\n" +
                "                    </p>\n" +
                "                    <p\n" +
                "                      style=\"\n" +
                "                        margin: 0;\n" +
                "                        font-size: 13px;\n" +
                "                        line-height: 22px;\n" +
                "                        color: #9ea8bb;\n" +
                "                      \"\n" +
                "                    >\n" +
                "                      Este es un correo electrónico generado automáticamente. No\n" +
                "                      responda a este correo electrónico. Si tiene algún\n" +
                "                      problema, contáctenos en ejemplo@gmail.com\n" +
                "                    </p>\n" +
                "                  </td>\n" +
                "                </tr>\n" +
                "              </tbody>\n" +
                "            </table>\n" +
                "            <table style=\"width: 100%; max-width: 620px; margin: 0 auto\">\n" +
                "              <tbody>\n" +
                "                <tr>\n" +
                "                  <td style=\"text-align: center; padding: 25px 20px 0\">\n" +
                "                    <p style=\"font-size: 13px\">\n" +
                "                      Copyright © 2021 Tech Mind. All rights reserved. <br />\n" +
                "                      Template Made By\n" +
                "                      <a style=\"color: #423431; text-decoration: none\" href=\"\"\n" +
                "                        >Tech Mind</a\n" +
                "                      >.\n" +
                "                    </p>\n" +
                "                    <p style=\"padding-top: 15px; font-size: 12px\">\n" +
                "                      This email was sent to you as a registered user of\n" +
                "                      <a style=\"color: #423431; text-decoration: none\" href=\"\"\n" +
                "                        >ejemplo.com</a\n" +
                "                      >. To update your emails preferences\n" +
                "                      <a style=\"color: #423431; text-decoration: none\" href=\"#\"\n" +
                "                        >click here</a\n" +
                "                      >.\n" +
                "                    </p>\n" +
                "                  </td>\n" +
                "                </tr>\n" +
                "              </tbody>\n" +
                "            </table>\n" +
                "          </td>\n" +
                "        </tr>\n" +
                "      </table>\n" +
                "    </center>\n" +
                "  </body>\n" +
                "</html>\n";
        contenido2 = contenido2.replace("[[URL]]", resetPassURL);
        // contenido2 = contenido2.replace("[[REQUEST]]", request);

        return contenido2;
    }

}
