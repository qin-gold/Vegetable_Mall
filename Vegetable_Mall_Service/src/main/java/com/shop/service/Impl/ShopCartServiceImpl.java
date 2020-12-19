package com.shop.service.Impl;

import com.shop.domain.Result;
import com.shop.domain.ShopCart;
import com.shop.mapper.IShopCartMapper;
import com.shop.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qsj
 */
@Service
public class ShopCartServiceImpl implements ShopCartService {
    @Autowired
    private IShopCartMapper shopCartMapper;

    @Override
    public List<ShopCart> findProductByuId(Integer u_id) {
        try {
            List<ShopCart> cartList = shopCartMapper.findProductByu_idf(u_id);
            return cartList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ShopCart> findProductByuIdAndPid(Integer u_id, Integer[] p_id) {
        List<ShopCart> shopCartList=new ArrayList<>();
        ShopCart shopCart=null;
        try {
        for (int i = 0; i<p_id.length; i++){
            shopCart = shopCartMapper.findProductByu_idp_id(u_id, p_id[i]);
            shopCartList.add(shopCart);
        }
            return shopCartList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Result EmptyShopCartByuId(Integer u_id) {
        Result result=new Result();
        try {
            Integer integer=0;
            List<ShopCart> list = shopCartMapper.findProductByu_idf(u_id);
            for (ShopCart shopCart : list) {
                integer= shopCartMapper.delProductToShopCart(shopCart);
            }
            if (integer>=0){
                result.setStateCode(200);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.setStateCode(500);
        return result;
    }

    @Override
    public Result saveProductToShopCart(ShopCart shopCart) {
        Result result = new Result();
        try {
            List<ShopCart> idj = shopCartMapper.findProductByu_idj(shopCart.getU_id());
            List list = new ArrayList();
            for (ShopCart s : idj) {
                list.add(s.getP_id());
            }
            //查询数据库中该用户是否存在该商品，否则执行更新
            Integer integer;
            if (list.contains(shopCart.getP_id())) {
                integer = shopCartMapper.IfUpdateProductToShopCart(shopCart);
            } else {
                integer = shopCartMapper.saveProductToShopCart(shopCart);
            }
            if (integer >= 1) {
                result.setStateCode(200);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.setStateCode(404);
        return result;
    }

    @Override
    public Result updateProductToShopCart(ShopCart shopCart) {
        Result result = new Result();
        Integer count = null;
        try {
            count = shopCartMapper.updateProductToShopCart(shopCart);
            if (count==1){
                result.setStateCode(200);
            }else {
                result.setStateCode(404);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setStateCode(404);
        }
        return result;
    }

    @Override
    public Result delProductToShopCart(ShopCart shopCart) {
        Result result = new Result();
        Integer count = null;
        try {
            count = shopCartMapper.delProductToShopCart(shopCart);
            if (count==1){
                result.setStateCode(200);
            }else {
                result.setStateCode(404);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setStateCode(404);
        }
        return result;
    }

    @Override
    public Integer findProductTotal(Integer u_id) {
        try {
            Integer total = shopCartMapper.findProductTotal(u_id);
            return total;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
