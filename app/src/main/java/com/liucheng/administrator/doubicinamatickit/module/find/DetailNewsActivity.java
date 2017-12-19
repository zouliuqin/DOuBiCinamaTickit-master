package com.liucheng.administrator.doubicinamatickit.module.find;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

import com.liucheng.administrator.doubicinamatickit.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.lang.annotation.Documented;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailNewsActivity extends AppCompatActivity {

    @BindView(R.id.text_Content)
   TextView textContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);
        ButterKnife.bind(this);
    String content =     Jsoup.parse(" \"<i><img src=\\\"\\\" data-src=\\\"https://img5.mtime.cn/mg/2017/12/19/160000.78161024.jpg\\\" data-original=\\\"https://img5.mtime.cn/mg/2017/12/19/160000.78161024.jpg\\\" /><br /></i> \n" +
                "  <i>（本文来自影视生活第一站 时光网）</i> \n" +
                "  <br /> \n" +
                "  <0000000000>　　时光网讯</b> 第90届奥斯卡最佳原创歌曲初选名单公布，共有70首歌曲入围。其中 \n" +
                "  <a href=\\\"https://movie.mtime.com/195064/\\\" target=\\\"_blank\\\">《美女与野兽》</a>的“Evermore”\\\"How Does a Moment Last Forever\\\"、 \n" +
                "  <a href=\\\"https://movie.mtime.com/234474/\\\" target=\\\"_blank\\\">《请以你的名字呼唤我》</a>里的\\\"Mystery Of Love\\\" \\\"Visions Of Gideon\\\"、 \n" +
                "  <a href=\\\"https://movie.mtime.com/227434/\\\" target=\\\"_blank\\\">《寻梦环游记》</a>的 \\\"Remember Me\\\"、 \n" +
                "  <a href=\\\"https://movie.mtime.com/149326/\\\" target=\\\"_blank\\\">《马戏之王》</a>的“This Is Me”以及 \n" +
                "  <a href=\\\"https://movie.mtime.com/224001/\\\" target=\\\"_blank\\\">《五十度黑》</a>的“I Don’t Wanna Live Forever”（“霉霉”泰勒斯威夫特创作）等影片的原创歌曲入围。 \n" +
                "  <br />　　同时，最佳电影配乐初选名单也出炉，共141部影片的配乐符合规定。奥斯卡常客汉斯·季默和约翰·威廉姆斯再度名列其中。值得一提的是，已经五获奥斯卡的 \n" +
                "  <a href=\\\"https://people.mtime.com/937718/\\\" target=\\\"_blank\\\">约翰·威廉姆斯</a>凭借 \n" +
                "  <a href=\\\"https://movie.mtime.com/211981/\\\" target=\\\"_blank\\\">《星球大战：最后的绝地武士》</a>和 \n" +
                "  <a href=\\\"https://movie.mtime.com/241666/\\\" target=\\\"_blank\\\">《华盛顿邮报》</a>双片入围。 \n" +
                "  <br /> \n" +
                "  <img src=\\\"\\\" data-src=\\\"https://img5.mtime.cn/mg/2017/12/19/160000.30310678.jpg\\\" data-original=\\\"https://img5.mtime.cn/mg/2017/12/19/160000.30310678.jpg\\\" width=\\\"310\\\" /> \n" +
                "  <p>约翰威廉姆斯能否再添一座小金人？</p>　　此外，有四部影片入围的有5位：丹尼尔·彭博顿( \n" +
                "  <a href=\\\"https://movie.mtime.com/242447/\\\" target=\\\"_blank\\\">《金钱世界》</a> \n" +
                "  <a href=\\\"https://movie.mtime.com/216639/\\\" target=\\\"_blank\\\">《亚瑟王：斗兽争霸》</a> \n" +
                "  <a href=\\\"https://movie.mtime.com/229536/\\\" target=\\\"_blank\\\">《马克·费尔特:扳倒白宫之人》</a> \n" +
                "  <a href=\\\"https://movie.mtime.com/232069/\\\" target=\\\"_blank\\\">《茉莉的牌局》</a>)、 \n" +
                "  <a href=\\\"https://people.mtime.com/1455904/\\\" target=\\\"_blank\\\">本杰明·沃菲斯齐</a>( \n" +
                "  <a href=\\\"https://movie.mtime.com/232866/\\\" target=\\\"_blank\\\">《安娜贝尔2：诞生》</a> \n" +
                "  <a href=\\\"https://movie.mtime.com/212468/\\\" target=\\\"_blank\\\">《银翼杀手2049》</a>(与汉斯·季默共同创作) \n" +
                "  <a href=\\\"https://movie.mtime.com/223677/\\\" target=\\\"_blank\\\">《救命解药》</a> \n" +
                "  <a href=\\\"https://movie.mtime.com/103523/\\\" target=\\\"_blank\\\">《小丑回魂》</a>)、 \n" +
                "  <a href=\\\"https://people.mtime.com/1265738/\\\" target=\\\"_blank\\\">迈克·吉亚奇诺</a>( \n" +
                "  <a href=\\\"https://movie.mtime.com/223152/\\\" target=\\\"_blank\\\">《亨利之书》</a> \n" +
                "  <a href=\\\"https://movie.mtime.com/227434/\\\" target=\\\"_blank\\\">《寻梦环游记》</a> \n" +
                "  <a href=\\\"https://movie.mtime.com/208175/\\\" target=\\\"_blank\\\">《蜘蛛侠：英雄归来》</a>《猩球崛起3》)、 \n" +
                "  <a href=\\\"https://people.mtime.com/1265210/\\\" target=\\\"_blank\\\">布莱恩·泰勒</a>( \n" +
                "  <a href=\\\"https://movie.mtime.com/224149/\\\" target=\\\"_blank\\\">《速度与激情8》</a> \n" +
                "  <a href=\\\"https://movie.mtime.com/125805/\\\" target=\\\"_blank\\\">《极限特工3》</a>(与罗伯特·莱德克共同配乐 ) \n" +
                "  <a href=\\\"https://movie.mtime.com/207927/\\\" target=\\\"_blank\\\">《新木乃伊》</a> \n" +
                "  <a href=\\\"https://movie.mtime.com/215833/\\\" target=\\\"_blank\\\">《恐龙战队》</a>)和罗伯·西蒙森(《寻父记》 \n" +
                "  <a href=\\\"https://movie.mtime.com/227482/\\\" target=\\\"_blank\\\">《天才少女》</a> \n" +
                "  <a href=\\\"https://movie.mtime.com/227171/\\\" target=\\\"_blank\\\">《三个老枪手》</a> \n" +
                "  <a href=\\\"https://movie.mtime.com/93274/\\\" target=\\\"_blank\\\">《纽约唯一活着的男孩》</a>)。 \n" +
                "  <br />　　美国电影科学与艺术学院的音乐部门成员将投票选出最终入围提名的名单，并与1月23日公布提名。第90届奥斯卡颁奖典礼将于明年3月4日举行。 \n" +
                "  <br /> \n" +
                "  <i>（更专业的影视媒体，更全面的票务周边服务，尽在时光网）</i>\"").text();

        textContent.setText(content);

    }
}
