package devy.lotto.data.controller;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class LottoController {

    private final Logger logger = LoggerFactory.getLogger(LottoController.class);

    private final String TAG_DRW_NO = "{drwNo}";
    private final String URL = "https://dhlottery.co.kr/gameResult.do?method=byWin&drwNo=" + TAG_DRW_NO;

    @GetMapping("/lotto")
    public String lotto(){
        try {
            Connection connect = Jsoup.connect(URL.replace(TAG_DRW_NO, "852"));
            Document parse = connect.execute().parse();

            logger.info(parse.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "lotto";

    }

}
