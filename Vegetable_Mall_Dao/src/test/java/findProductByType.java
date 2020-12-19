//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.shop.domain.Orders;
//import com.shop.domain.Product;
//import com.shop.domain.ShopCart;
//import com.shop.mapper.IOrderMapper;
//import com.shop.mapper.IProductMapper;
//import com.shop.mapper.IShopCartMapper;
//import com.shop.utils.MyUtil;
//import org.apache.ibatis.session.SqlSession;
//import org.junit.Test;
//;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class findProductByType {
//    @Test
//    public void test1() throws Exception {
//        SqlSession session = MyUtil.getSession();
//        IProductMapper mapper = session.getMapper(IProductMapper.class);
//        List<Product> byType = mapper.findProductByType(4);
//        System.out.println(byType);
//
//    }
//    @Test
//    public void test2() throws Exception {
//        SqlSession session = MyUtil.getSession();
//        IProductMapper mapper = session.getMapper(IProductMapper.class);
//        PageHelper.startPage(1,8);
//        List<Product> type = mapper.findProductByType(4);
//        PageInfo<Product> pageInfo=new PageInfo<>(type);
//        System.out.println(pageInfo);
//    }
//    @Test
//    public void test3(){
//        long millis = System.currentTimeMillis();
//        String valueOf = String.valueOf(millis);
//        String s = valueOf.substring(valueOf.length() - 6);
//        System.out.println(s);
//        System.out.println(System.currentTimeMillis());
//    }
//    @Test
//    public void test4() throws Exception {
//        SqlSession session = MyUtil.getSession();
//        IShopCartMapper mapper = session.getMapper(IShopCartMapper.class);
//        List<ShopCart> users = mapper.findProductByu_idf(3);
//        System.out.println(users);
//
//    }
//    @Test
//    public void test6() throws Exception {
//        SqlSession session = MyUtil.getSession();
//        IShopCartMapper mapper = session.getMapper(IShopCartMapper.class);
//        List<ShopCart> users = mapper.findProductByu_idj(3);
//        List list=new ArrayList();
//        for (ShopCart user : users) {
//            list.add(user.getP_id());
//        }
//        boolean b = list.contains(6);
//        System.out.println(b);
//        System.out.println(users);
//
//    }
//    @Test
//    public void test5() throws Exception {
//        SqlSession session = MyUtil.getSession();
//        IShopCartMapper mapper = session.getMapper(IShopCartMapper.class);
//        ShopCart shopCart=new ShopCart();
//        shopCart.setU_id(4);
//        shopCart.setP_id(5);
//        shopCart.setP_count(4);
//        Integer integer = mapper.saveProductToShopCart(shopCart);
//        session.commit();
//        System.out.println(integer);
//    }
//    @Test
//    public void test7(){
//            List<String>list = new ArrayList<String>();
//            list.add("草莓");  //向列表中添加数据
//            list.add("香蕉");  //向列表中添加数据
//            list.add("菠萝");  //向列表中添加数据
//            for(int i=0;i<list.size();i++){  //通过循环输出列表中的内容
//                System.out.println(i+":"+list.get(i));
//            }
//            String o = "菠萝";
//            System.out.println("list对象中是否包含元素"+o+":"+list.contains(o));  //判断字符串中是否包含指定字符串对象
//    }
//
//    @Test
//    public void test8() throws Exception {
//        SqlSession session = MyUtil.getSession();
//        IShopCartMapper mapper = session.getMapper(IShopCartMapper.class);
//        Integer total = mapper.findProductTotal(3);
//        System.out.println(total);
//    }
//
//    @Test
//    public void test9() throws Exception {
//        SqlSession session = MyUtil.getSession();
//        IShopCartMapper mapper = session.getMapper(IShopCartMapper.class);
//        ShopCart shopCart = mapper.findProductByu_idp_id(3, 3);
//        System.out.println(shopCart);
//    }
//
//    @Test
//    public void test10() throws Exception {
//        SqlSession session = MyUtil.getSession();
//        IOrderMapper mapper = session.getMapper(IOrderMapper.class);
//        Orders orders = mapper.findOrderById("2020120721481607348938772");
//        System.out.println(orders);
//    }
//
//    @Test
//    public void test11() throws Exception {
//        SqlSession session = MyUtil.getSession();
//        IProductMapper mapper = session.getMapper(IProductMapper.class);
//        Product product=new Product();
//        product.setP_name("牛肉");
//        List<Product> likeProduct = mapper.adminFindLikeProduct(product);
//        System.out.println(likeProduct);
//    }
//}
