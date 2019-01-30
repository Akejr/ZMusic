package zmusic;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Evandro
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ComboBox temas;
    @FXML
    private Pane tela1, tela2;
    @FXML
    private ImageView conf;
    @FXML
    private Button parar, tocar;
    @FXML
    private TextField campo;
    @FXML
    private CheckBox prim;
    @FXML
    private WebView web;
    @FXML
    private Button discord;

    WebEngine engine;
    String url;

    @FXML
    private void DiscordBtn(ActionEvent evt) throws URISyntaxException, IOException {
        java.awt.Desktop.getDesktop().browse(new java.net.URI("https://discord.gg/n5vxwyt"));
    }

    @FXML
    private void PararMusica(ActionEvent event) {
        engine.load("https://www.google.com");

    }

    @FXML
    private void TocarTecla(KeyEvent evt) {
        if (evt.getCode() == KeyCode.ENTER) {
            switch (campo.getText()) {
                case "!playlist br":
                    engine.load("https://www.youtube.com/watch?v=hsUCF7PNpCM&list=PLFgquLnL59amgHJoypBNANk_038__LaXM");
                    break;
                case "!playlist angola":
                    engine.load("http://youtube-playlist-randomizer.valami.info/playlist3.php?pl[]=PL2PGAUgtyfboWEwjI-Kkzh_1W1pn8dA0c&&removedups=on");
                    System.out.println("angola");
                    break;
                case "!playlist kpop":
                    engine.load("http://youtube-playlist-randomizer.valami.info/playlist3.php?pl[]=PLTDluH66q5mpm-Bsq3GlwjMOHITt2bwXE&&removedups=on");
                    break;
                case "!playlist mix":
                    engine.load("http://youtube-playlist-randomizer.valami.info/playlist3.php?pl[]=PLw-VjHDlEOguL2K_NwIl_tYcs9_FSt5v_&&removedups=on_");
                    break;
                case "!playlist rap br":
                    engine.load("http://youtube-playlist-randomizer.valami.info/playlist3.php?pl[]=PL_Q15fKxrBb6fqHivxHRODikCMZG_ovOp&&removedups=on");
                    break;
                case "!playlist rap":
                    engine.load("http://youtube-playlist-randomizer.valami.info/playlist3.php?pl[]=PLw-VjHDlEOgsIgak3vJ7mrcy-OscZ6OAs&&removedups=on");
                    break;
                case "!playlist acustico":
                case "!playlist acústico":
                    engine.load("http://youtube-playlist-randomizer.valami.info/playlist3.php?pl[]=PLyduYuc3faBh9oPTWMqzLoJi5In25WTaf&&removedups=on");
                    break;
                case "!playlist funk":
                    engine.load("http://youtube-playlist-randomizer.valami.info/playlist3.php?pl[]=PL_Q15fKxrBb5F3Rf2WO6cpHT-nLEE49AX&&removedups=on");
                    break;
                case "!playlist indie":
                    engine.load("http://youtube-playlist-randomizer.valami.info/playlist3.php?pl[]=PLrpga-n1MvA-4PrNGdmhteNu4Lkp_09vk&&removedups=on");
                    break;
                default:
                    processo();
                    engine.load(url);
                    break;
            }
        }
    }

    @FXML
    private void TocarBtn(ActionEvent evt) {
        switch (campo.getText()) {
            case "!playlist br":
                engine.load("https://www.youtube.com/watch?v=hsUCF7PNpCM&list=PLFgquLnL59amgHJoypBNANk_038__LaXM");
                break;
            case "!playlist angola":
                engine.load("http://youtube-playlist-randomizer.valami.info/playlist3.php?pl[]=PL2PGAUgtyfboWEwjI-Kkzh_1W1pn8dA0c&&removedups=on");
                System.out.println("angola");
                break;
            case "!playlist kpop":
                engine.load("http://youtube-playlist-randomizer.valami.info/playlist3.php?pl[]=PLTDluH66q5mpm-Bsq3GlwjMOHITt2bwXE&&removedups=on");
                break;
            case "!playlist mix":
                engine.load("http://youtube-playlist-randomizer.valami.info/playlist3.php?pl[]=PLw-VjHDlEOguL2K_NwIl_tYcs9_FSt5v_&&removedups=on_");
                break;
            case "!playlist rap br":
                engine.load("http://youtube-playlist-randomizer.valami.info/playlist3.php?pl[]=PL_Q15fKxrBb6fqHivxHRODikCMZG_ovOp&&removedups=on");
                break;
            case "!playlist rap":
                engine.load("http://youtube-playlist-randomizer.valami.info/playlist3.php?pl[]=PLw-VjHDlEOgsIgak3vJ7mrcy-OscZ6OAs&&removedups=on");
                break;
            case "!playlist acustico":
            case "!playlist acústico":
                engine.load("http://youtube-playlist-randomizer.valami.info/playlist3.php?pl[]=PLyduYuc3faBh9oPTWMqzLoJi5In25WTaf&&removedups=on");
                break;
            case "!playlist funk":
                engine.load("http://youtube-playlist-randomizer.valami.info/playlist3.php?pl[]=PL_Q15fKxrBb5F3Rf2WO6cpHT-nLEE49AX&&removedups=on");
                break;
            case "!playlist indie":
                engine.load("http://youtube-playlist-randomizer.valami.info/playlist3.php?pl[]=PLrpga-n1MvA-4PrNGdmhteNu4Lkp_09vk&&removedups=on");
                break;
            case "!merdalher":
                engine.load("https://www.youtube.com/watch?v=6k9CgyNbHXE");
                break;
            default:
                processo();
                engine.load(url);
                break;
        }

    }

    private void processo() {
        String codificação = "UTF-8";

        try {
            String texto = campo.getText() + " youtube";
            Document google = Jsoup.connect("https://www.bing.com/search?q=" + URLEncoder.encode(texto, codificação))
                    .userAgent("Mozilla/5.0 Chrome/26.0.1410.64 Safari/537.31")
                    .timeout(5000)
                    .get();

            Elements pegarLinks = google.getElementsByTag("cite");
            if (pegarLinks.isEmpty()) {
                System.out.println("Sem resultados");
                return;
            }
            String PrimeiroLink = pegarLinks.get(0).text();
            System.out.println(PrimeiroLink);
            url = PrimeiroLink;

        } catch (IOException e) {
            System.out.println("Erro: " + e);
        }

    }

    @FXML
    private void AbirConf(MouseEvent event) {
        if (tela2.isVisible() == false) {
            tela2.setVisible(true);
            Image image = new Image(getClass().getResourceAsStream("/imagens/baixo3.png"));
            conf.setImage(image);
        } else {
            tela2.setVisible(false);
            Image image = new Image(getClass().getResourceAsStream("/imagens/seta3.png"));
            conf.setImage(image);
        }
    }

    @FXML
    private void PrimeiroPlano(ActionEvent evt) {
        if (prim.isArmed() == true) {
            ZMusic.PrimPlano("a");
        }
        if (prim.isArmed() == false) {
            ZMusic.PrimPlano("b");
        }
    }

    @FXML
    private void MudarTema(ActionEvent event) {
        if (temas.getValue() == "Light") {
            tela1.setStyle("-fx-background-color:  #E7EAED");
            tela2.setStyle("-fx-background-color:  #E7EAED");
            campo.setStyle("-fx-text-fill: #323232");
            tocar.setStyle("-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.9) , 10,0,0,1 )");
            tocar.setStyle("-fx-background-color:  #FFFFFF");
            parar.setStyle("-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.9) , 10,0,0,1 )");
            parar.setStyle("-fx-background-color:  #FFFFFF");
            prim.setStyle("-fx-text-fill:  #121212");
        } else if (temas.getValue() == "Dark") {
            tela1.setStyle("-fx-background-color:  #121212");
            tela2.setStyle("-fx-background-color:   #121212");
            campo.setStyle(" -fx-text-fill: #97C792");
            tocar.setStyle("-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.9) , 10,0,0,1 )");
            tocar.setStyle("-fx-background-color:   #97C792");
            parar.setStyle("-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.9) , 10,0,0,1 )");
            parar.setStyle("-fx-background-color:   #97C792");
            prim.setStyle("-fx-text-fill: #c9c7c7");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        engine = web.getEngine();

        ObservableList<String> options
                = FXCollections.observableArrayList(
                        "Dark",
                        "Light"
                );
        temas.setItems(options);
    }

}
