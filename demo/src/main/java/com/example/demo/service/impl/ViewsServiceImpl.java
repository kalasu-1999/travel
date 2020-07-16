package com.example.demo.service.impl;

import com.example.demo.entity.Views;
import com.example.demo.mapper.ViewsMapper;
import com.example.demo.service.ImgUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewsServiceImpl implements com.example.demo.service.ViewsService {
    @Autowired
    private ViewsMapper viewsMapper;
    @Autowired
    private ImgUtilService imgUtilService;


    @Override
    public int insertViews(String viewName, String viewImage, String content) {
        String img = imgUtilService.saveImg(viewImage);
        return viewsMapper.insert(new Views(null, viewName, img, content));
    }

    @Override
    public int updateViews(Integer viewId, String viewName, String viewImage, String content) {
        Views views = viewsMapper.selectByPrimaryKey(viewId);
        if (views == null) {
            return -1;
        } else {
            String[] split = viewImage.split("/");
            if (!split[split.length - 1].equals(views.getViewImage())) {
                imgUtilService.deleteImg(views.getViewImage());
                viewImage = imgUtilService.saveImg(viewImage);
            } else {
                viewImage = views.getViewImage();
            }
        }
        return viewsMapper.updateByPrimaryKey(new Views(viewId, viewName, viewImage, content));
    }

    @Override
    public Views selectViewsByViewId(Integer viewId) {
        Views views = viewsMapper.selectByPrimaryKey(viewId);
        views.setViewImage(imgUtilService.getImgPath(views.getViewImage()));
        return views;
    }

    @Override
    public List<Views> selectViewsByHint(String hint) {
        List<Views> views = viewsMapper.selectByHint(hint);
        for (Views view : views) {
            view.setViewImage(imgUtilService.getImgPath(view.getViewImage()));
        }
        return views;
    }

    @Override
    public List<Views> selectAllViews() {
        List<Views> views = viewsMapper.selectAll();
        for (Views view : views) {
            view.setViewImage(imgUtilService.getImgPath(view.getViewImage()));
        }
        return views;
    }

    @Override
    public int deleteViewsByViewId(Integer viewId) {
        Views views = viewsMapper.selectByPrimaryKey(viewId);
        if (views == null){
            return -1;
        } else {
            imgUtilService.deleteImg(views.getViewImage());
            return viewsMapper.deleteByPrimaryKey(viewId);
        }
    }
}
