package com.mkim12.getImgs.Load;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/load")
public class LoadController {
    WebClient webClient;

    LoadController() {
        webClient = new WebClient(BrowserVersion.CHROME);

        webClient.getOptions().setThrowExceptionOnScriptError(false);
    }

    @GetMapping("/test")
    public void Load() {
        String url = "http://www.auction.co.kr";
        try {
            HtmlPage page = (HtmlPage)webClient.getPage(url);

            System.out.println(page);
        } catch (IOException e) {
            System.out.println(e);
        }
    }


}
