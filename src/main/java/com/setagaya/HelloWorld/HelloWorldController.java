package com.setagaya.HelloWorld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Controller
public class HelloWorldController {

    @GetMapping("/helloWorld")
    public String helloWorld(Model model){

        //画面表示する日時の取得
        LocalDateTime date1 = LocalDateTime.now();
        DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String fdate1 = dtformat.format(date1);
        model.addAttribute( "datetime", fdate1);

        //メッセージの場合分けに使用する時刻の取得
        LocalTime localTimeNow =  date1.toLocalTime();
        LocalTime branchTime = LocalTime.of(17,00,00);


        //メッセージの分岐
        if(localTimeNow.isAfter(branchTime)) {
            model.addAttribute( "message","本日もお疲れさまでした！！ゆっくり休んでくださいね！");
        } else {
            model.addAttribute( "message", "お疲れ様です！！本日も定時まで頑張りましょう！");
        }

        return "index";
    }

}
