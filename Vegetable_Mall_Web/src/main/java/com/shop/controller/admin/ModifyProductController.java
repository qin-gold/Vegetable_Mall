package com.shop.controller.admin;

import com.github.pagehelper.PageInfo;
import com.shop.domain.Description;
import com.shop.domain.Product;
import com.shop.service.Impl.ProductServiceImpl;
import com.shop.domain.Result;
import com.shop.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;


/**
 * @author qsj
 * 修改商品信息
 */
@Controller
@RequestMapping("/admin")
public class ModifyProductController {
    @Autowired
    private ProductServiceImpl productService;

    @RequestMapping(value = "/findProductById", params = "p_id")
    public String addProduct(Model model, Product p_id) {
            Product product = productService.findProductId(p_id.getP_id());
            List<Description> type = productService.findAllProductType();
            model.addAttribute("Product", product);
            model.addAttribute("Description", type);
        return "admin/updateGoods";
    }

    @ResponseBody
    @RequestMapping("/updateProduct")
    public Result updateProduct(Result result,Product product) {
        System.out.println(product);
        try {
            result = productService.updateProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/delProduct0")
    public Result delProduct0(Product product, Result result) {
        try {
            result= productService.updateProductState0(product.getP_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/delProduct1")
    public Result delProduct1(Product product, Result result) {
        try {
            result= productService.updateProductState1(product.getP_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/findAllProduct")
    public String findProduct(Model model, @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                              @RequestParam(name = "size", required = true, defaultValue = "5") Integer size) {
        try {
            List<Product> productList = productService.adminFindAllProduct(page, size);
            PageInfo<Product> pageInfo = new PageInfo<>(productList);
            model.addAttribute("list", pageInfo);
            String str="findAllProduct";
            model.addAttribute("str", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin/productControl";
    }

    @RequestMapping("/findHotProduct")
    public String findHotProduct(Model model) {
        try {
            List<Product> productList = productService.adminFindHotProduct();
            PageInfo<Product> pageInfo = new PageInfo<>(productList);
            model.addAttribute("list", pageInfo);
            String str="findHotProduct";
            model.addAttribute("str", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin/productControl";
    }

    @RequestMapping("/addGood")
    public String addGood(Model model) {
        List<Description> type = productService.findAllProductType();
        model.addAttribute("Description", type);
        return "admin/addGoods";
    }

    @ResponseBody
    @RequestMapping("/addProduct")
    public void addProducts(Product product, @RequestParam(name = "file") MultipartFile file, HttpServletRequest request, HttpServletResponse response,Result result) {
        String fileName = UploadUtil.getUpload(file, request);
        response.setContentType("text/html; charset=utf-8");
        if (fileName != null) {
            product.setP_image(fileName);
            product.setP_date(new Timestamp(System.currentTimeMillis()));
            try {
                result = productService.saveProduct(product);
                if (result.getStateCode()==200) {
                    response.getWriter().print("<script>alert('添加成功');window.location.href='/admin/findAllProduct'</script>");
                } else {
                    response.getWriter().print("<script>alert('添加失败');window.location.href='/admin/findAllProduct'</script>");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.getWriter().print("<script>alert('添加失败');window.location.href='/admin/findAllProduct'</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @RequestMapping("/findLikeProduct")
    public String findLikeProduct(Model model, @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                  @RequestParam(name = "size", required = true, defaultValue = "5") Integer size, String text) {
        Product product = new Product();
        if (text == null) {
            findProduct(model, page, size);
            return "productControl";
        }
            product.setP_name(text);
        try {
            product.setP_id(Integer.valueOf(text));
        } catch (Exception e) {
            product.setP_id(null);
        }
        try {
            List<Product> likeProduct = productService.adminFindLikeProduct(product, page, size);
            PageInfo<Product> pageInfo = new PageInfo<>(likeProduct);
            String str="findLikeProduct";
            model.addAttribute("str", str);
            model.addAttribute("list", pageInfo);
            model.addAttribute("text", text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin/productControl";
    }

}
