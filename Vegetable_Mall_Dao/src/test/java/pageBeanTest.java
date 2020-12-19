//import com.shop.domain.Description;
//import com.shop.domain.Product;
//import com.shop.mapper.IProductMapper;
//import com.shop.utils.MyUtil;
//import org.apache.ibatis.session.SqlSession;
//import org.junit.Test;
//
//import java.util.List;
//
//public class pageBeanTest {
//    @Test
//    public void Test1() throws Exception {
//        SqlSession session = MyUtil.getSession();
//        IProductMapper mapper = session.getMapper(IProductMapper.class);
//        Integer count = mapper.findTotalCount();
//        System.out.println(count);
//    }
//
////    @Test
////    public void Test2() throws Exception{
////        SqlSession session = MyUtil.getSession();
////        IProductMapper mapper = session.getMapper(IProductMapper.class);
////        List<Product> byPage = mapper.findProductByPage(5, 5);
////        for (Product product : byPage) {
////            System.out.println(product);
////        }
////    }
//        @Test
//    public void Test3() throws Exception{
//            SqlSession session = MyUtil.getSession();
//            IProductMapper mapper = session.getMapper(IProductMapper.class);
//            Product product=new Product();
//            product.setP_id(1);
//            List<Product> likeProduct = mapper.findLikeProduct(product);
//            for (Product product1 : likeProduct) {
//                System.out.println(product1);
//            }
//        }
//}
