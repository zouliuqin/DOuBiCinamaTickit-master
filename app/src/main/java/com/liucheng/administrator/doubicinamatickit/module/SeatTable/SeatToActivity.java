package com.liucheng.administrator.doubicinamatickit.module.SeatTable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.entity.Cinema;
import com.qfdqc.views.seattable.SeatTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SeatToActivity extends AppCompatActivity {
    public SeatTable seatTableView;

    /**
     * 接收到的电影院信息
     */
    private Cinema.CinemaBean cinemaBean;


    int s;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//         // 隐藏标题栏
//                 this.getSupportActionBar().hide();
//                 // 隐藏状态栏
//                 getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager
//                         .LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_seatto);
        cinemaBean = getIntent().getParcelableExtra("cinema");


//        int c = (int) (Math.random()*30);
     s = (int) (Math.random()*20+60);









        seatTableView = (SeatTable) findViewById(R.id.seatView);


        seatTableView.setScreenName("8号厅荧幕");//设置屏幕名称
        seatTableView.setMaxSelected(3);//设置最多选中

        seatTableView.setSeatChecker(new SeatTable.SeatChecker() {

            @Override
            public boolean isValidSeat(int row, int column) {
                if(column==2) {
                    return false;
                }
                return true;
            }

            @Override
            public boolean isSold(int row, int column) {
                // 获取所有键值对对象的集合
                    Set<Map.Entry<Integer, Integer>> set = map.entrySet();
                    // 遍历键值对对象的集合，得到每一个键值对对象
                StringBuffer buffer = new StringBuffer();


                for (int i = 0;i<3;i++){
                    int x= (int) (Math.random()*8+2);
                    int y = (int) (Math.random()*8+2);

                    String select = "row=="+x+"&&"+"column=="+y+"||";
                    buffer.append(select);
                }

              String av =  buffer.toString();
                av.replace("\"","").substring(0,av.length()-2);
                Log.d("0000000000", av.replace("\"","").substring(0,av.length()-2));
                if(row==5&&column==5||row==6&&column==7||row==2){




                    return true;


                }







                return false;
            }

            @Override
            public void checked(int row, int column) {
                Toast.makeText(SeatToActivity.this, "erhyewgbrf", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void unCheck(int row, int column) {

            }

            @Override
            public String[] checkedSeatTxt(int row, int column) {
                return null;
            }

        });
        seatTableView.setData(11,13);

    }

}
