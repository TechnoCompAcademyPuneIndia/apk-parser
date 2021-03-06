package net.dongliu.apk.parser;

import net.dongliu.apk.parser.bean.CertificateMeta;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.Locale;

/**
 * Main method for parser apk
 *
 * @author Liu Dong {@literal <im@dongliu.net>}
 */
public class Main {
    public static void main(String[] args) throws IOException, CertificateException {
        String apkFile = args[0];
        try (ApkParser parser = new ApkParser(apkFile)) {
            parser.setPreferredLocale(Locale.SIMPLIFIED_CHINESE);
            System.out.println(parser.getApkMeta());
            List<CertificateMeta> certList = parser.getCertificateMetaList();
            for (CertificateMeta certificateMeta : certList) {
                System.out.println(certificateMeta);
            }
        }

    }
}
