package com.shop.service;

import com.shop.domain.Description;
import com.shop.domain.Product;
import com.shop.domain.Result;

import java.util.List;

/**
 *
 * @author qsj Cotter
 * @date 2020/10/7
 */
public interface ProductService {

    /** 管理员查询所有的商品
     * @param pageNum
     * @param PageSize
     * @return
     * @throws Exception
     */
    List<Product> adminFindAllProduct(int pageNum, int PageSize) throws Exception;

    /** 管理员查询所有的热销商品
     * @return
     * @throws Exception
     */
    List<Product> adminFindHotProduct() throws Exception;

    /**   查询所有的商品
     * @param pageNum
     * @param PageSize
     * @return
     * @throws Exception
     */
    List<Product> findAllProduct(int pageNum, int PageSize) throws Exception;

    /**   查询热销的商品
     * @return
     * @throws Exception
     */
    List<Product> findHotProduct() throws Exception;

    /** 新增商品的方法
     * @param product
     * @return  Integer
     * @throws Exception
     */
    Result saveProduct(Product product) throws Exception;

    /** 根据ID查询商品
     * @param id
     * @return
     * @throws Exception
     */
    Product findProductId(Integer id) throws Exception;

    /** 查询所有商品的类型
     * @return List<Description>
     * @throws Exception
     */
    List<Description> findAllProductType() throws Exception;

    /** 更新商品信息
     * @param product
     * @return  Integer
     * @throws Exception
     */
    Result updateProduct(Product product) throws Exception;

    /** 修改商品状态
     * @param p_id
     * @return  Integer
     * @throws Exception
     */
    Result updateProductState0(Integer p_id) throws Exception;

    /** 修改商品状态
     * @param p_id
     * @return  Integer
     * @throws Exception
     */
    Result updateProductState1(Integer p_id) throws Exception;

    /** 根据商品类型查询商品
     * @param d_id
     * @param pageNum
     * @param PageSize
     * @return
     * @throws Exception
     */
    List<Product> findProductByType(Integer d_id ,int pageNum,int PageSize) throws Exception;

    /** 模糊查询商品
     * @param product
     * @param pageNum
     * @param PageSize
     * @return
     * @throws Exception
     */
    List<Product> findLikeProduct(Product product,int pageNum,int PageSize)throws Exception;

    /** 管理员模糊查询商品
     * @param product
     * @param pageNum
     * @param PageSize
     * @return
     * @throws Exception
     */
    List<Product> adminFindLikeProduct(Product product,int pageNum,int PageSize)throws Exception;

}
