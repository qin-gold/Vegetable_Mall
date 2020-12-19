package com.shop.service.Impl;

import com.github.pagehelper.PageHelper;
import com.shop.domain.Description;
import com.shop.domain.Product;
import com.shop.domain.Result;
import com.shop.mapper.IProductMapper;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  商品修改服务
 * @author qsj
 * @date 2020/11/7
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private IProductMapper iProductMapper;

        @Override
        public List<Product> adminFindAllProduct(int pageNum, int PageSize) throws Exception {
            PageHelper.startPage(pageNum,PageSize);
            return iProductMapper.adminFindAllProduct();
        }

        @Override
        public List<Product> adminFindHotProduct() throws Exception {
            PageHelper.startPage(1,7);
            return iProductMapper.findHotProduct();
        }

        @Override
        public List<Product> findAllProduct(int pageNum, int PageSize) throws Exception {
            PageHelper.startPage(pageNum,PageSize);
            return iProductMapper.findAllProduct();
        }

        @Override
        public List<Product> findHotProduct() throws Exception {
            PageHelper.startPage(1,7);
            return iProductMapper.adminFindHotProduct();
        }

        @Override
        public Result saveProduct(Product product) throws Exception {
            Result result=new Result();
            product.setP_isHot(0);
            product.setP_state(1);
            Integer save = iProductMapper.saveProduct(product);
            if (save>=1){
                result.setStateCode(200);
            }else{
                result.setStateCode(500);
            }
            return result;
        }

        @Override
        public Product findProductId(Integer id) {
            try {
                Product productId = iProductMapper.findProductId(id);
                return productId;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public List<Description> findAllProductType() {
            try {
                List<Description> type = iProductMapper.findAllProductType();
                return type;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        public Result updateProduct(Product product) throws Exception {
            Result result=new Result();
            Integer total = iProductMapper.findHotProductTotal();
            if (total>=8){
                result.setStateCode(502);
            }else {
                Integer integer = iProductMapper.updateProduct(product);
                if (integer>=1){
                    result.setStateCode(200);
                }else{
                    result.setStateCode(500);
                }
            }
            return result;
        }

        @Override
        public Result updateProductState0(Integer id) throws Exception {
            Result result=new Result();
            Integer integer = iProductMapper.updateProductState0(id);
            if (integer>=1){
                result.setStateCode(200);
            }else{
                result.setStateCode(500);
            }
            return result;
        }

        @Override
        public Result updateProductState1(Integer id) throws Exception {
            Result result=new Result();
            Integer integer = iProductMapper.updateProductState1(id);
            if (integer>=1){
                result.setStateCode(200);
            }else{
                result.setStateCode(500);
            }
            return result;
        }

        @Override
        public List<Product> findProductByType(Integer d_id, int pageNum, int PageSize) throws Exception {
            PageHelper.startPage(pageNum,PageSize);
            List<Product> productByType = iProductMapper.findProductByType(d_id);
            return productByType;
        }

    @Override
            public List<Product> findLikeProduct(Product product,int pageNum,int PageSize) throws Exception {
                PageHelper.startPage(pageNum,PageSize);
                List<Product> likeProduct = iProductMapper.findLikeProduct(product);
                return likeProduct;
            }

    @Override
        public List<Product> adminFindLikeProduct(Product product, int pageNum, int PageSize) throws Exception {
            PageHelper.startPage(pageNum,PageSize);
            List<Product> likeProduct = iProductMapper.adminFindLikeProduct(product);
            return likeProduct;
        }

}
