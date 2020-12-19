//import com.github.pagehelper.PageInfo;
//import com.shop.domain.*;
//import com.shop.service.OrderService;
//import com.shop.service.ProductService;
//import com.shop.service.ShopCartService;
//import com.shop.service.UserService;
//import com.shop.utils.OrdersUtil;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.sql.Timestamp;
//import java.util.List;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringJUnitConfig(locations = "classpath:ApplicationContext.xml")
//public class SpringTest {
//    @Autowired
//    private UserService service;
//    @Autowired
//    private ProductService productService;
//    @Autowired
//    private ShopCartService shopCartService;
//    @Autowired
//    private OrderService orderService;
//    @Test
//    public void SpringTest2() throws Exception {
//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        UserService bean = applicationContext.getBean("userServiceImpl",UserService.class);
//        User byId = bean.findUserById(1);
//        System.out.println(byId);
//    }
//    @Test
//    public void Sprngs() throws Exception{
//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        UserService bean = applicationContext.getBean("userServiceImpl",UserService.class);
//        User users = bean.findUsername("秦世交");
//        System.out.println(users.getAddress());
//    }
//
//    @Test
//    public void TestFindByType() throws Exception {
////        Description byType = productService.findProductByType(4, 1, 1);
////        PageInfo<Product>pageInfo=new PageInfo<>(byType.getProductList());
////        System.out.println(pageInfo);
//
//    }
//
//    @Test
//    public void TestFindByType1() throws Exception {
//        List<Product> byType1 = productService.findProductByType(4, 1, 1);
//        PageInfo<Product>pageInfo=new PageInfo<>(byType1);
//        System.out.println(pageInfo);
//
//    }
//    @Test
//    public void TestUpdateShopCart() throws Exception {
////        ShopCart shopCart=new ShopCart();
////        shopCart.setU_id(3);
////        shopCart.setP_id(2);
////        shopCart.setP_count(8);
////        Result result = shopCartService.updateProductToShopCart(shopCart);
////        System.out.println(result.getStateCode());
//
//    }
//    @Test
//    public void TestDelShopCart() throws Exception {
////        ShopCart shopCart=new ShopCart();
////        shopCart.setU_id(3);
////        shopCart.setP_id(2);
////        shopCart.setP_count(8);
////        Result result = shopCartService.delProductToShopCart(shopCart);
////        System.out.println(result.getStateCode());
//    }
//    @Test
//    public void TestDelShopCart1() throws Exception {
//        Integer[] integers={2,3,8,1};
//        List<ShopCart> list = shopCartService.findProductByuIdAndPid(3, integers);
//        System.out.println(list);
//    }
//
//    @Test
//    public void TestDelShopCart2() throws Exception {
//        List<ShopCart> shopCarts = shopCartService.findProductByuId(3);
//        System.out.println(shopCarts);
//    }
//
//    @Test
//    public void Test3() throws Exception {
//        Orders orders=new Orders();
//        orders.setO_id(OrdersUtil.getOrderNo());
//        orders.setU_id(3);
//        orders.setPaystate(0);
//        orders.setAddress("湖南长沙");
//        orders.setTelephone("123456789");
//        orders.setTotalmoney(3.5f);
//        orders.setCreate_time(new Timestamp(System.currentTimeMillis()));
//    }
//    @Test
//    public void Test4() throws Exception {
//        Orders orders=new Orders();
//        orders.setO_id("2020120721481607348938772");
//        orderService.updateOrdersById(orders);
//
//    }
//    @Test
//    public void Test5() throws Exception {
//        List<Orders> byId = orderService.findAllOrdersById(3, 1, 1);
//        System.out.println(byId);
//
//    }
//    @Test
//    public void Test6() throws Exception {
//        List<Orders> byId = orderService.findAllOrders( 1, 3);
//        System.out.println(byId);
//
//    }
//
//
//
//}
