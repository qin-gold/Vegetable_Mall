package com.shop.mapper;

import com.shop.domain.Description;
import com.shop.domain.Product;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.OneToOne;
import java.sql.JDBCType;
import java.util.List;

/**
 *
 * @author qsj Cotter
 * @date 2020/6/6
 */
//@Repository
public interface IProductMapper {
    /** 管理员查询所有的商品
     * @return List集合
     * @throws Exception
     */
    @Select({"select * from product"})
    @Results(id = "description",value = {
            @Result(id = true, column = "p_id", property = "p_id"),
            @Result( column = "p_name",property = "p_name"),
            @Result( column = "p_price",property = "p_price"),
            @Result( column = "p_date",property = "p_date"),
            @Result( column = "p_inventory",property = "p_inventory"),
            @Result( column = "p_overview",property = "p_overview" ),
            @Result( column = "d_id",property = "d_id"),
            @Result( column = "p_image",property = "p_image"),
            @Result( column = "p_state",property = "p_state"),
            @Result( column = "p_isHot",property = "p_isHot"),
            @Result( property = "description", column = "d_id",
                    one = @One(select = "com.shop.mapper.IProductMapper.findTypeById"))
    })
    List<Product> adminFindAllProduct() throws Exception;

    /** 查询所有的商品
     * @return
     * @throws Exception
     */
    @Select({"select * from product where p_state=0"})
    @ResultMap(value = "description")
    List<Product> findAllProduct() throws Exception;

    /** 管理员查询热销产品
     * @return
     * @throws Exception
     */
    @Select({"select * from product where p_isHot=1"})
    @ResultMap(value = "description")
    List<Product> adminFindHotProduct() throws Exception;

    /** 查询热销产品
     * @return
     * @throws Exception
     */
    @Select({"select * from product where p_state=1 and p_isHot=1"})
    @ResultMap(value = "description")
    List<Product> findHotProduct() throws Exception;

    /** 查询热销产品数量
     * @return
     * @throws Exception
     */
    @Select({"select count(p_name) from product where p_isHot=1"})
    Integer findHotProductTotal() throws Exception;

    /** 通过id查询商品
     * @param id 传入的ID值
     * @return
     * @throws Exception
     */
    @Select("select * from product where p_id=#{p_id}")
    @ResultMap(value = "description")
    Product findProductId(Integer id) throws Exception;

    /** 根据id查询产品类型
     * @param d_id
     * @return
     * @throws Exception
     */
    @Select("select * from description where d_id=#{d_id}")
    Description findTypeById(String d_id) throws Exception;

    /** 查询所有产品类型
     * @return List<Description>
     * @throws Exception
     */
    @Select("select * from description")
    List<Description> findAllProductType() throws Exception;

    /** 更新一条数据
     * @param product
     * @return boolean
     * @throws Exception
     */
    @Update("update product set p_name=#{p_name}," +
            "p_price=#{p_price},p_inventory=#{p_inventory}," +
            "p_overview=#{p_overview},d_id=#{d_id},p_isHot=#{p_isHot}" +
            " where p_id=#{p_id}")
    Integer updateProduct(Product product) throws Exception;

    /** 更新库存数据
     * @param product
     * @return boolean
     * @throws Exception
     */
    @Update("update product set p_inventory=#{p_inventory} where p_id=#{p_id}")
    boolean updateProductInventory(Product product) throws Exception;

    /** 插入一条数据
     * @param product
     * @return boolean
     * @throws Exception
     */
    @Insert("insert into product(p_id,p_name,p_price,p_date,p_inventory,p_overview,d_id,p_image,p_state,p_isHot)"
            + " values(#{p_id},#{p_name},#{p_price},#{p_date},#{p_inventory},#{p_overview},#{d_id},#{p_image},#{p_state},#{p_isHot})")
    Integer saveProduct(Product product) throws Exception;

    /** 删除一条数据（弃置）
     * @param id
     * @return boolean
     * @throws Exception
     */
    @Insert("delete from product where p_id=#{p_id}")
    Integer delProduct(Integer id) throws Exception;

    /** 改变商品状态
     * @param id
     * @return boolean
     * @throws Exception
     */
    @Update("update product set p_state= 0 where p_id=#{p_id}")
    Integer updateProductState0(Integer id) throws Exception;

    /** 改变商品状态
     * @param id
     * @return boolean
     * @throws Exception
     */
    @Update("update product set p_state= 1 where p_id=#{p_id}")
    Integer updateProductState1(Integer id) throws Exception;

    /** 查询所有的总数
     * @return
     * @throws Exception
     */
    @Select("select count(*) from product")
    Integer findTotalCount() throws Exception;

    /** 模糊查询商品
     * @return
     * @throws Exception
     * @param product
     */
    @Select("select * from product where p_state = 1 and (p_name like concat('%',#{p_name},'%') or p_overview like concat('%',#{p_overview},'%')) ")
    @ResultMap(value = "description")
    List<Product> findLikeProduct(Product product) throws Exception;

    /** 管理员模糊查询商品
     * @return
     * @throws Exception
     * @param product
     */
    @Select("select * from product where p_name like concat('%',#{p_name},'%') or p_overview like concat('%',#{p_overview},'%') ")
    @ResultMap(value = "description")
    List<Product> adminFindLikeProduct(Product product) throws Exception;

    /** 根据id查询产品信息
     * @param d_id
     * @return Product
     * @throws Exception
     */
    @Select("select * from Product where d_id=#{d_id}")
    List<Product> findById(Integer d_id) throws Exception;

    /** 根据类型查找商品
     * @param d_id
     * @return
     * @throws Exception
     */
    @Select("SELECT * FROM product p LEFT JOIN description d ON p.d_id=d.d_id WHERE d.d_id=#{d_id} and p_state = 1 ")
    @Results({
            @Result(id = true, column = "p_id", property = "p_id"),
            @Result( column = "p_name",property = "p_name"),
            @Result( column = "p_price",property = "p_price"),
            @Result( column = "p_date",property = "p_date"),
            @Result( column = "p_inventory",property = "p_inventory"),
            @Result( column = "p_overview",property = "p_overview" ),
            @Result( column = "p_image",property = "p_image"),
            @Result( column = "p_state",property = "p_state"),
            @Result( column = "p_isHot",property = "p_isHot"),
            @Result( column = "d_id",property = "d_id"),
            @Result( column = "d_id",property = "description.d_id"),
            @Result( column = "d_remark",property = "description.d_remark"),
    })
    List<Product> findProductByType(Integer d_id)throws Exception;

}
