package com.example.demo.service.impl;

import com.example.demo.entity.Views;
import com.example.demo.mapper.ViewsMapper;
import com.example.demo.service.ImgUtilService;
import com.example.demo.service.ViewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class ViewsServiceImpl implements ViewsService {
    @Autowired
    private ViewsMapper viewsMapper;
    @Autowired
    private ImgUtilService imgUtilService;


    @Override
    public int insertViews(String viewName, MultipartFile file, String content) {
        String viewImage = null;
        if (file != null) {
            viewImage = imgUtilService.saveImg(file);
        }
        return viewsMapper.insert(new Views(null, viewName, viewImage, content));
    }

    @Override
    public int updateViews(Integer viewId, String viewName, MultipartFile file, String content) {
        Views views = viewsMapper.selectByPrimaryKey(viewId);
        String viewImage;
        if (views == null) {
            return -1;
        } else {
            if (file == null) {
                viewImage = views.getViewImage();
            } else {
                if (views.getViewImage() != null && !views.getViewImage().equals("")) {
                    if (file.getName().equals(views.getViewImage())) {
                        imgUtilService.deleteImg(views.getViewImage());
                        viewImage = imgUtilService.saveImg(file);
                    } else {
                        viewImage = views.getViewImage();
                    }
                }
                viewImage = imgUtilService.saveImg(file);
            }
        }
        return viewsMapper.updateByPrimaryKey(new Views(viewId, viewName, viewImage, content));
    }

    @Override
    public Views selectViewsByViewId(Integer viewId) {
        Views views = viewsMapper.selectByPrimaryKey(viewId);
        if (views.getViewImage() != null && !views.getViewImage().equals("")) {
            views.setViewImage(imgUtilService.getImgPath(views.getViewImage()));
        }
        return views;
    }

    @Override
    public List<Views> selectViewsByHint(String hint) {
        List<Views> views = viewsMapper.selectByHint(hint);
        for (Views view : views) {
            if (view.getViewImage() != null && !view.getViewImage().equals("")) {
                view.setViewImage(imgUtilService.getImgPath(view.getViewImage()));
            }
        }
        return views;
    }

    @Override
    public List<Views> selectAllViews() {
        List<Views> views = viewsMapper.selectAll();
        for (Views view : views) {
            if (view.getViewImage() != null && !view.getViewImage().equals("")) {
                view.setViewImage(imgUtilService.getImgPath(view.getViewImage()));
            }
        }
        return views;
    }

    @Override
    public int deleteViewsByViewId(Integer viewId) {
        Views views = viewsMapper.selectByPrimaryKey(viewId);
        if (views == null) {
            return -1;
        } else {
            if (views.getViewImage() != null && !views.getViewImage().equals("")) {
                imgUtilService.deleteImg(views.getViewImage());
            }
            return viewsMapper.deleteByPrimaryKey(viewId);
        }
    }
}
