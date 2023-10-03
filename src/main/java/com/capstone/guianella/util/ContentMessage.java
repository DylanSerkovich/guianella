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

    public static String resChangePassHTML(String username, String email, String resetPassURL, String request) {

        String contenido2 = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "  <head>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
                "    <title>Empresa Guianella Credenciales</title>\n" +
                "    <style>\n" +
                "      img {\n" +
                "        border: none;\n" +
                "        -ms-interpolation-mode: bicubic;\n" +
                "        max-width: 100%;\n" +
                "      }\n" +
                "\n" +
                "      body {\n" +
                "        background-color: #f6f6f6;\n" +
                "        font-family: sans-serif;\n" +
                "        -webkit-font-smoothing: antialiased;\n" +
                "        font-size: 14px;\n" +
                "        line-height: 1.4;\n" +
                "        margin: 0;\n" +
                "        padding: 0;\n" +
                "        -ms-text-size-adjust: 100%;\n" +
                "        -webkit-text-size-adjust: 100%;\n" +
                "      }\n" +
                "\n" +
                "      table {\n" +
                "        border-collapse: separate;\n" +
                "        mso-table-lspace: 0pt;\n" +
                "        mso-table-rspace: 0pt;\n" +
                "        width: 100%;\n" +
                "      }\n" +
                "      table td {\n" +
                "        font-family: sans-serif;\n" +
                "        font-size: 14px;\n" +
                "        vertical-align: top;\n" +
                "      }\n" +
                "\n" +
                "      .body {\n" +
                "        background-color: #f6f6f6;\n" +
                "        width: 100%;\n" +
                "      }\n" +
                "\n" +
                "      .container {\n" +
                "        display: block;\n" +
                "        margin: 0 auto !important;\n" +
                "        /* makes it centered */\n" +
                "        max-width: 580px;\n" +
                "        padding: 10px;\n" +
                "        width: 580px;\n" +
                "      }\n" +
                "      .content {\n" +
                "        box-sizing: border-box;\n" +
                "        display: block;\n" +
                "        margin: 0 auto;\n" +
                "        max-width: 580px;\n" +
                "        padding: 10px;\n" +
                "      }\n" +
                "\n" +
                "      .main {\n" +
                "        background: #ffffff;\n" +
                "        border-radius: 3px;\n" +
                "        width: 100%;\n" +
                "      }\n" +
                "\n" +
                "      .wrapper {\n" +
                "        box-sizing: border-box;\n" +
                "        padding: 20px;\n" +
                "      }\n" +
                "\n" +
                "      .content-block {\n" +
                "        padding-bottom: 10px;\n" +
                "        padding-top: 10px;\n" +
                "      }\n" +
                "\n" +
                "      .footer {\n" +
                "        clear: both;\n" +
                "        margin-top: 10px;\n" +
                "        text-align: center;\n" +
                "        width: 100%;\n" +
                "      }\n" +
                "      .footer td,\n" +
                "      .footer p,\n" +
                "      .footer span,\n" +
                "      .footer a {\n" +
                "        color: #999999;\n" +
                "        font-size: 12px;\n" +
                "        text-align: center;\n" +
                "      }\n" +
                "\n" +
                "      h1,\n" +
                "      h2,\n" +
                "      h3,\n" +
                "      h4 {\n" +
                "        color: #000000;\n" +
                "        font-family: sans-serif;\n" +
                "        font-weight: 400;\n" +
                "        line-height: 1.4;\n" +
                "        margin: 0;\n" +
                "        margin-bottom: 30px;\n" +
                "      }\n" +
                "\n" +
                "      h1 {\n" +
                "        font-size: 35px;\n" +
                "        font-weight: 300;\n" +
                "        text-align: center;\n" +
                "        text-transform: capitalize;\n" +
                "      }\n" +
                "\n" +
                "      p,\n" +
                "      ul,\n" +
                "      ol {\n" +
                "        font-family: sans-serif;\n" +
                "        font-size: 14px;\n" +
                "        font-weight: normal;\n" +
                "        margin: 0;\n" +
                "        margin-bottom: 15px;\n" +
                "      }\n" +
                "      p li,\n" +
                "      ul li,\n" +
                "      ol li {\n" +
                "        list-style-position: inside;\n" +
                "        margin-left: 5px;\n" +
                "      }\n" +
                "\n" +
                "      a {\n" +
                "        color: #3498db;\n" +
                "        text-decoration: underline;\n" +
                "      }\n" +
                "\n" +
                "      .btn {\n" +
                "        box-sizing: border-box;\n" +
                "        width: 100%;\n" +
                "      }\n" +
                "      .btn > tbody > tr > td {\n" +
                "        padding-bottom: 15px;\n" +
                "      }\n" +
                "      .btn table {\n" +
                "        width: auto;\n" +
                "      }\n" +
                "      .btn table td {\n" +
                "        background-color: #ffffff;\n" +
                "        border-radius: 5px;\n" +
                "        text-align: center;\n" +
                "      }\n" +
                "      .btn a {\n" +
                "        background-color: #ffffff;\n" +
                "        border: solid 1px #3498db;\n" +
                "        border-radius: 5px;\n" +
                "        box-sizing: border-box;\n" +
                "        color: #3498db;\n" +
                "        cursor: pointer;\n" +
                "        display: inline-block;\n" +
                "        font-size: 14px;\n" +
                "        font-weight: bold;\n" +
                "        margin: 0;\n" +
                "        padding: 12px 25px;\n" +
                "        text-decoration: none;\n" +
                "        text-transform: capitalize;\n" +
                "      }\n" +
                "\n" +
                "      .btn-primary table td {\n" +
                "        background-color: #3498db;\n" +
                "      }\n" +
                "\n" +
                "      .btn-primary a {\n" +
                "        background-color: #3498db;\n" +
                "        border-color: #3498db;\n" +
                "        color: #ffffff;\n" +
                "      }\n" +
                "\n" +
                "      .last {\n" +
                "        margin-bottom: 0;\n" +
                "      }\n" +
                "\n" +
                "      .first {\n" +
                "        margin-top: 0;\n" +
                "      }\n" +
                "\n" +
                "      .align-center {\n" +
                "        text-align: center;\n" +
                "      }\n" +
                "\n" +
                "      .align-right {\n" +
                "        text-align: right;\n" +
                "      }\n" +
                "\n" +
                "      .align-left {\n" +
                "        text-align: left;\n" +
                "      }\n" +
                "\n" +
                "      .clear {\n" +
                "        clear: both;\n" +
                "      }\n" +
                "\n" +
                "      .mt0 {\n" +
                "        margin-top: 0;\n" +
                "      }\n" +
                "\n" +
                "      .mb0 {\n" +
                "        margin-bottom: 0;\n" +
                "      }\n" +
                "\n" +
                "      .preheader {\n" +
                "        color: transparent;\n" +
                "        display: none;\n" +
                "        height: 0;\n" +
                "        max-height: 0;\n" +
                "        max-width: 0;\n" +
                "        opacity: 0;\n" +
                "        overflow: hidden;\n" +
                "        mso-hide: all;\n" +
                "        visibility: hidden;\n" +
                "        width: 0;\n" +
                "      }\n" +
                "\n" +
                "      .powered-by a {\n" +
                "        text-decoration: none;\n" +
                "      }\n" +
                "\n" +
                "      hr {\n" +
                "        border: 0;\n" +
                "        border-bottom: 1px solid #f6f6f6;\n" +
                "        margin: 20px 0;\n" +
                "      }\n" +
                "      @media only screen and (max-width: 620px) {\n" +
                "        table.body h1 {\n" +
                "          font-size: 28px !important;\n" +
                "          margin-bottom: 10px !important;\n" +
                "        }\n" +
                "        table.body p,\n" +
                "        table.body ul,\n" +
                "        table.body ol,\n" +
                "        table.body td,\n" +
                "        table.body span,\n" +
                "        table.body a {\n" +
                "          font-size: 16px !important;\n" +
                "        }\n" +
                "        table.body .wrapper,\n" +
                "        table.body .article {\n" +
                "          padding: 10px !important;\n" +
                "        }\n" +
                "        table.body .content {\n" +
                "          padding: 0 !important;\n" +
                "        }\n" +
                "        table.body .container {\n" +
                "          padding: 0 !important;\n" +
                "          width: 100% !important;\n" +
                "        }\n" +
                "        table.body .main {\n" +
                "          border-left-width: 0 !important;\n" +
                "          border-radius: 0 !important;\n" +
                "          border-right-width: 0 !important;\n" +
                "        }\n" +
                "        table.body .btn table {\n" +
                "          width: 100% !important;\n" +
                "        }\n" +
                "        table.body .btn a {\n" +
                "          width: 100% !important;\n" +
                "        }\n" +
                "        table.body .img-responsive {\n" +
                "          height: auto !important;\n" +
                "          max-width: 100% !important;\n" +
                "          width: auto !important;\n" +
                "        }\n" +
                "      }\n" +
                "\n" +
                "      @media all {\n" +
                "        .ExternalClass {\n" +
                "          width: 100%;\n" +
                "        }\n" +
                "        .ExternalClass,\n" +
                "        .ExternalClass p,\n" +
                "        .ExternalClass span,\n" +
                "        .ExternalClass font,\n" +
                "        .ExternalClass td,\n" +
                "        .ExternalClass div {\n" +
                "          line-height: 100%;\n" +
                "        }\n" +
                "        .apple-link a {\n" +
                "          color: inherit !important;\n" +
                "          font-family: inherit !important;\n" +
                "          font-size: inherit !important;\n" +
                "          font-weight: inherit !important;\n" +
                "          line-height: inherit !important;\n" +
                "          text-decoration: none !important;\n" +
                "        }\n" +
                "        #MessageViewBody a {\n" +
                "          color: inherit;\n" +
                "          text-decoration: none;\n" +
                "          font-size: inherit;\n" +
                "          font-family: inherit;\n" +
                "          font-weight: inherit;\n" +
                "          line-height: inherit;\n" +
                "        }\n" +
                "        .btn-primary table td:hover {\n" +
                "          background-color: #34495e !important;\n" +
                "        }\n" +
                "        .btn-primary a:hover {\n" +
                "          background-color: #34495e !important;\n" +
                "          border-color: #34495e !important;\n" +
                "        }\n" +
                "      }\n" +
                "    </style>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <span class=\"preheader\"\n" +
                "      >This is preheader text. Some clients will show this text as a\n" +
                "      preview.</span\n" +
                "    >\n" +
                "    <table\n" +
                "      role=\"presentation\"\n" +
                "      border=\"0\"\n" +
                "      cellpadding=\"0\"\n" +
                "      cellspacing=\"0\"\n" +
                "      class=\"body\"\n" +
                "    >\n" +
                "      <tr>\n" +
                "        <td>&nbsp;</td>\n" +
                "        <td class=\"container\">\n" +
                "          <div class=\"content\">\n" +
                "            <!-- START CENTERED WHITE CONTAINER -->\n" +
                "            <table role=\"presentation\" class=\"main\">\n" +
                "              <!-- START MAIN CONTENT AREA -->\n" +
                "              <tr>\n" +
                "                <td class=\"wrapper\">\n" +
                "                  <table\n" +
                "                    role=\"presentation\"\n" +
                "                    border=\"0\"\n" +
                "                    cellpadding=\"0\"\n" +
                "                    cellspacing=\"0\"\n" +
                "                  >\n" +
                "                    <tr>\n" +
                "                      <td>\n" +
                "                        <img\n" +
                "                          src=\"https://res.cloudinary.com/dolhmjhkc/image/upload/v1696020499/Guianella/logo_Guianella_ovognc.png\"\n"
                +
                "                          alt=\"\"\n" +
                "                          style=\"height: 12rem; display: block; margin: 0 auto\"\n" +
                "                        />\n" +
                "                        <p>Hola,¡Bienvenido a la empresa!</p>\n" +
                "                        <p>\n" +
                "                          El administrador ha creado una cuenta en Guianella\n" +
                "                          para usted. Haga clic en el botón a continuación para\n" +
                "                          establecer su contraseña e iniciar sesión a su cuenta\n" +
                "                        </p>\n" +
                "                        <table\n" +
                "                          role=\"presentation\"\n" +
                "                          border=\"0\"\n" +
                "                          cellpadding=\"0\"\n" +
                "                          cellspacing=\"0\"\n" +
                "                          class=\"btn btn-primary\"\n" +
                "                        >\n" +
                "                          <tbody>\n" +
                "                            <tr>\n" +
                "                              <td align=\"left\">\n" +
                "                                <table\n" +
                "                                  role=\"presentation\"\n" +
                "                                  border=\"0\"\n" +
                "                                  cellpadding=\"0\"\n" +
                "                                  cellspacing=\"0\"\n" +
                "                                >\n" +
                "                                  <tbody>\n" +
                "                                    <tr>\n" +
                "                                      <td>\n" +
                "                                        <a href=\"[[URL]]\" target=\"_blank\"\n" +
                "                                          >Establecer Contraseña</a\n" +
                "                                        >\n" +
                "                                      </td>\n" +
                "                                    </tr>\n" +
                "                                  </tbody>\n" +
                "                                </table>\n" +
                "                              </td>\n" +
                "                            </tr>\n" +
                "                          </tbody>\n" +
                "                        </table>\n" +
                "                        <p>\n" +
                "                          O use este enlace:\n" +
                "                          <a\n" +
                "                            href=\"[[URL]]\"\n" +
                "                            target=\"_blank\"\n" +
                "                            rel=\"noopener noreferrer\"\n" +
                "                            >[[URL]]</a\n" +
                "                          >\n" +
                "                        </p>\n" +
                "                        <p>\n" +
                "                          En caso de que el enlace no funciones, comuniquese con\n" +
                "                          su administrador\n" +
                "                        </p>\n" +
                "                        <p>\n" +
                "                          Enlace de acceso:<a\n" +
                "                            href=\"[[REQUEST]]\"\n" +
                "                            target=\"_blank\"\n" +
                "                            rel=\"noopener noreferrer\"\n" +
                "                            >[[REQUEST]]</a\n" +
                "                          >\n" +
                "                        </p>\n" +
                "                        <p>Nombre de usuario: [[USER]]</p>\n" +
                "                      </td>\n" +
                "                    </tr>\n" +
                "                  </table>\n" +
                "                </td>\n" +
                "              </tr>\n" +
                "\n" +
                "              <!-- END MAIN CONTENT AREA -->\n" +
                "            </table>\n" +
                "            <!-- END CENTERED WHITE CONTAINER -->\n" +
                "\n" +
                "            <!-- START FOOTER -->\n" +
                "            <div class=\"footer\">\n" +
                "              <table\n" +
                "                role=\"presentation\"\n" +
                "                border=\"0\"\n" +
                "                cellpadding=\"0\"\n" +
                "                cellspacing=\"0\"\n" +
                "              >\n" +
                "                <tr>\n" +
                "                  <td class=\"content-block\">\n" +
                "                    <span class=\"apple-link\"\n" +
                "                      >Company Inc, 3 Abbey Road, San Francisco CA 94102</span\n" +
                "                    >\n" +
                "                    <br />\n" +
                "                    Don't like these emails?\n" +
                "                    <a href=\"http://i.imgur.com/CScmqnj.gif\">Unsubscribe</a>.\n" +
                "                  </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                  <td class=\"content-block powered-by\">\n" +
                "                    Powered by <a href=\"http://htmlemail.io\">HTMLemail</a>.\n" +
                "                  </td>\n" +
                "                </tr>\n" +
                "              </table>\n" +
                "            </div>\n" +
                "            <!-- END FOOTER -->\n" +
                "          </div>\n" +
                "        </td>\n" +
                "        <td>&nbsp;</td>\n" +
                "      </tr>\n" +
                "    </table>\n" +
                "  </body>\n" +
                "</html>\n";
        contenido2 = contenido2.replace("[[URL]]", resetPassURL);
        contenido2 = contenido2.replace("[[REQUEST]]", request);
        contenido2 = contenido2.replace("[[USER]]", username);

        return contenido2;
    }

}
