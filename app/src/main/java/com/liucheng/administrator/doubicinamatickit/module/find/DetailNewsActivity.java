package com.liucheng.administrator.doubicinamatickit.module.find;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

import com.liucheng.administrator.doubicinamatickit.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.lang.annotation.Documented;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailNewsActivity extends AppCompatActivity {

    @BindView(R.id.text_Content)
  WebView textContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);
        ButterKnife.bind(this);
//       textContent.getSettings().setJavaScriptEnabled(true);//启用js
//       textContent.getSettings().setBlockNetworkImage(false);//解决图片不显示
//        textContent.getSettings().setDatabaseEnabled(true);
//        textContent.getSettings().setDefaultTextEncodingName("UTF-8") ;
        textContent.getSettings().setJavaScriptEnabled(true);
        textContent.getSettings().setDatabaseEnabled(false);

        String html ="<p>成龙领衔，罗志祥、欧阳娜娜、夏侯云姗主演的<b>贺岁档唯一动作大片</b><b>《机器之血》</b>将在<b>12月22日（周五）</b>上映。</p> \n" +
            "  <p><br /></p> \n" +
            "  <p><img src=\\\"\\\" data-src=\\\"https://img5.mtime.cn/mg/2017/12/20/020618.50893880.jpg\\\" data-original=\\\"https://img5.mtime.cn/mg/2017/12/20/020618.50893880.jpg\\\" /></p> \n" +
            "  <p><br /></p> \n" +
            "  <p>《机器之血》讲述了特工林东（成龙饰）和骇客李森（罗志祥饰）联手揭开阴谋并对抗邪恶大boss的故事。与以往电影不同，《机器之血》涉及到了科幻元素，而最后大boss亦是生化人，力量很强大，不知道成龙的拳脚能否敌得过坏人。<br /></p> \n" +
            "  <p><br /></p> \n" +
            "  <p> \n" +
            "   <video data-video-type=\\\"3\\\" data-video-id=\\\"145802\\\" poster=\\\"https://img5.mtime.cn/mg/2017/12/18/194305.20430059.jpg\\\" controls=\\\"controls\\\" src=\\\"https://short-video-ksccdn.mtime.cn/playrecord/7323a036386447d574b609e29853797e_6Gj8aPUO_145802_720p.mp4?k=edbc4f0afe2575bccd53e0c590bd24f8&t=1513796341\\\"></video><br /></p> \n" +
            "  <p><br /></p> \n" +
            "  <p><b>看过终极预告，总结一下《机器之血》4大看点：</b></p> \n" +
            "  <p><br /></p> \n" +
            "  <p><b>真枪实弹 火药全开</b></p> \n" +
            "  <p><br /></p> \n" +
            "  <p>与以往成龙电影不同，《机器之血》里夹杂了更多枪战戏份。而且都是实拍！据悉，为了片中的枪战戏，剧组共四五十支真枪，100公斤火药，弹药3万发。而影片开头的13分钟枪战戏中，都采用真枪实弹，几十条枪一起发威，让大哥也连连说怕。而片中爆炸戏也非常过瘾，都是之前成龙电影极少见到的。</p> \n" +
            "  <p><br /></p> \n" +
            "  <p><img src=\\\"\\\" data-src=\\\"https://img5.mtime.cn/mg/2017/12/20/020619.66038382.jpg\\\" data-original=\\\"https://img5.mtime.cn/mg/2017/12/20/020619.66038382.jpg\\\" /></p> \n" +
            "  <p><img src=\\\"\\\" data-src=\\\"https://img5.mtime.cn/mg/2017/12/20/020619.29676344.jpg\\\" data-original=\\\"https://img5.mtime.cn/mg/2017/12/20/020619.29676344.jpg\\\" /></p> \n" +
            "  <p><img src=\\\"\\\" data-src=\\\"https://img5.mtime.cn/mg/2017/12/20/020619.75444006.jpg\\\" data-original=\\\"https://img5.mtime.cn/mg/2017/12/20/020619.75444006.jpg\\\" /></p> \n" +
            "  <p><br /></p> \n" +
            "  <p><br /></p> \n" +
            "  <p><b>动作飙车 毫不含糊</b></p> \n" +
            "  <p><br /></p> \n" +
            "  <p>而影片中的打斗场景，都由“成家班”承担！一众动作演员很早就开始集结排练，各种打斗片段的走位都需要精细演练，才能呈现出最终效果。<br /></p> \n" +
            "  <p><br /></p> \n" +
            "  <p>大哥的戏中怎能没有飙车戏呢？其实飙车戏的设置，除了让观众更爽，还有赞助商的新款车出现！</p> \n" +
            "  <p><br /></p> \n" +
            "  <p><img src=\\\"\\\" data-src=\\\"https://img5.mtime.cn/mg/2017/12/20/020619.21612915.jpg\\\" data-original=\\\"https://img5.mtime.cn/mg/2017/12/20/020619.21612915.jpg\\\" /></p> \n" +
            "  <p><br /></p> \n" +
            "  <p><br /></p> \n" +
            "  <p><b>无保护 真动作 决战悉尼歌剧院</b></p> \n" +
            "  <p><br /></p> \n" +
            "  <p>成龙的武打，必定是重头戏。这次高难度的武打片段，选在悉尼歌剧院楼顶。开工前，工作人员毕竟经过将近一小时的身体检查，才能被放到楼顶。而且成龙的动作戏，都没有任何威亚保护，就在倾斜的歌剧院楼顶做危险动作。而上楼一次，也要禁水，省去上厕所的麻烦。</p> \n" +
            "  <p><br /></p> \n" +
            "  <p><img src=\\\"\\\" data-src=\\\"https://img5.mtime.cn/mg/2017/12/20/020619.43118911.jpg\\\" data-original=\\\"https://img5.mtime.cn/mg/2017/12/20/020619.43118911.jpg\\\" /></p> \n" +
            "  <p><img src=\\\"\\\" data-src=\\\"https://img5.mtime.cn/mg/2017/12/20/020619.71186777.jpg\\\" data-original=\\\"https://img5.mtime.cn/mg/2017/12/20/020619.71186777.jpg\\\" /></p> \n" +
            "  <p><br /></p> \n" +
            "  <p><br /></p> \n" +
            "  <p><b>搞笑担当“龙女郎”</b></p> \n" +
            "  <p><br /></p> \n" +
            "  <p>罗志祥，则是片中的搞笑担当！相对于大哥的硬汉气质，罗志祥的文弱书生的表演则让严肃的故事多了很多轻松愉快的桥段。他成为名副其实的“龙女郎”，真是夺了欧阳娜娜和夏侯云姗的戏。<br /></p> \n" +
            "  <p><br /></p> \n" +
            "  <p><img src=\\\"\\\" data-src=\\\"https://img5.mtime.cn/mg/2017/12/20/020620.81041678.jpg\\\" data-original=\\\"https://img5.mtime.cn/mg/2017/12/20/020620.81041678.jpg\\\" /></p> \n" +
            "  <p><br /></p> \n" +
            "  <p><br /></p> \n" +
            "  <p><b>喜欢动作片的朋友不要错过12月15日上映《机器之血》！</b>一起见证更爽的动作戏，更原味的成龙武打，以及成龙与罗志祥的“龙猪组合”。</p> \n" +
            "  <p><br /></p> \n" +
            "  <p><b>另，《机器之血》提供更多版本，让您体会更多观影乐趣</b></p> \n" +
            "  <p><b><br /></b></p> \n" +
            "  <p><img src=\\\"\\\" data-src=\\\"https://img5.mtime.cn/mg/2017/12/20/020620.51734304.jpg\\\" data-original=\\\"https://img5.mtime.cn/mg/2017/12/20/020620.51734304.jpg\\\" /></p> \n" +
            "  <p><br /></p>";

        Document doc =  Jsoup.parse(html);
        Elements html2 = doc.select("i");
        html2.html("<i><i/>");
//        Elements html3 = doc.select("");

//        Elements  ac =html.not("a");
//        Elements ac = html2.not("i");
        String content1 = doc.toString();
        String  content = content1.replace("时光网讯"," ");
        String str = "'\\'";
        String sb = str.replace("'","");
        Log.d("88888888888",sb);

        String Content= content.replaceAll("\\\\","");
        String ab = Content.replaceAll("&quot;","");
        Log.d("000000000000",ab);




        textContent.loadDataWithBaseURL("", ab, "text/html", "utf-8", null);



    }
}
