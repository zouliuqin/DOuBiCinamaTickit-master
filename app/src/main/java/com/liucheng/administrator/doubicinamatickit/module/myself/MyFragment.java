package com.liucheng.administrator.doubicinamatickit.module.myself;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.fragment.BaseFragment;
import com.liucheng.administrator.doubicinamatickit.module.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2017/10/15 0015.
 */

public class MyFragment extends BaseFragment {


    @BindView(R.id.im_my_fragment_bg)
    ImageView imMyFragmentBg;
    @BindView(R.id.iv_my_fragment_my_head_portrait)
    CircleImageView ivMyFragmentMyHeadPortrait;
    Unbinder unbinder;
    @BindView(R.id.imageView_actionbar)
    ImageView imageViewActionbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.my_fragment, container, false);
        initialUI();

        unbinder = ButterKnife.bind(this, contentView);
        return contentView;
    }

    @Override
    public void initialUI() {
        actionBar = contentView.findViewById(R.id.include_actionbar_my);

        initiaActionBar(-1, null, "个人中心", R.drawable.setting);
        ivMyFragmentMyHeadPortrait = contentView.findViewById(R.id.iv_my_fragment_my_head_portrait);


    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.imageView_actionbar, R.id.iv_my_fragment_my_head_portrait})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageView_actionbar:
                Intent intent2 = new Intent(getActivity(),MySetActivity.class);
                startActivity(intent2);
                break;
            case R.id.iv_my_fragment_my_head_portrait:
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
