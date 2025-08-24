package com.ibm.controller;

import com.ibm.pojo.Result;
import com.ibm.pojo.dept;
import com.ibm.service.DeptService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DeptController_BAK {

////    @RequestMapping("/depts")
////    public List<dept> list() {
////        //加载并读写 【dept.txt】文件
////        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("dept.txt");
////        List<String> lines = IOUtils.readLines(inputStream, "UTF-8");
////
////        //解析文本中的数据，封装为对象；多个对象到集合
////        for (String line : lines) {
////            System.out.println(line);
////        }
////
////        List<dept> deptList = lines.stream().map(line -> {
////            String[] split = line.split(",");
////            int deptId = Integer.parseInt(split[0]);
////            String deptName = split[1];
////            LocalDateTime updateTime = LocalDateTime.parse(split[2], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
////            return new dept(deptId,deptName,updateTime);
////        }).collect(Collectors.toList());
////
////        //相应数据
////        return deptList;
////    }
//
//    /**
//     *
//     * @return
//     */
//
////    //@RequestMapping(value = "/depts", method = RequestMethod.GET)  //限定只能【GET】请求
////    @GetMapping("/depts")
////    public Result list() {
////        //加载并读写 【dept.txt】文件
////        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("dept.txt");
////        List<String> lines = IOUtils.readLines(inputStream, "UTF-8");
////
////        //解析文本中的数据，封装为对象；多个对象到集合
////        for (String line : lines) {
////            System.out.println(line);
////        }
////
////        List<dept> deptList = lines.stream().map(line -> {
////            String[] split = line.split(",");
////            int id = Integer.parseInt(split[0]);
////            String name = split[1];
////            LocalDateTime updateTime = LocalDateTime.parse(split[2], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
////            return new dept(id, name, updateTime);
////        }).collect(Collectors.toList());
////
////        //相应数据
////        return Result.success(deptList);
////    }
//
//    /**
//     * 一个接口有还几个是现实，DI时要以下方法来指定
//     * ①primary
//     * ②Autowired + Qualifier("")
//     * ③Resource(name="")
//      */
////    @Qualifier("deptServiceImp2")  //指定要生效的【Bean】的名字
////    @Autowired
//    @Resource (name = "deptServiceImp")  //*一个接口有好几个实现时用。【Resource】注解，就不需要【Autowired】和【Qualifier】注解
//    private DeptService deptService; // = new DeptServiceImp();
//
//    /**
//     *改造后的3层架构：【Controller】
//     * @return
//     */
//    //@RequestMapping(value = "/depts", method = RequestMethod.GET)  //限定只能【GET】请求
//    @GetMapping("/depts")
//    public Result list() {
//
//        List<dept> deptList = deptService.getDept();
//        //相应数据
//        return Result.success(deptList);
//    }
//
//    /**
//     * 方式二
//     * 当传递来的参数明和，接受的参数名不一致时，用【RequestParam】。 【id】 --> 【deptID】
//     * 但是使用【RequestParam】，参数必须传过来。
//     * 不想传时，@RequestParam(value = "id",required = false),追加【required = false】
//     * 因为默认是【required = ture】
//     * @param deptId
//     * @return
//     */
////    @DeleteMapping("/depts")
////    public Result delete(@RequestParam(value = "id",required = false) Integer deptId) {
////        System.out.println(deptId);
////
////        return Result.success();
////    }
//
//    /**
//     * 方式三
//     * 当传来的参数名和接受的参数名一样时，省略【RequestParam】
//     * @param id
//     * @return
//     */
//    @DeleteMapping("/depts")
//    public Result delete(Integer id) {
//        System.out.println(id);
//       deptService.deleteById(id);
//        return Result.success();
//    }
//
//
////    /**
////     * 方式一
////     * 当传来的参数名和接受的参数名一样时，省略【RequestParam】
////     * @param id
////     * @return
////     */
//////    // 以前的写法，参数的接受方法。
////    @DeleteMapping
////    public Result delete(HttpServletRequest request) {
////        String id = request.getParameter("id");
////        Integer deptId = Integer.parseInt(id);
////
////        System.out.println(deptId);
////
////        return Result.success();
////    }
//
//    @PostMapping("/depts")
//    public Result add(@RequestBody dept dept) {
//
//        System.out.println(dept);
//        deptService.add(dept);
//        return Result.success();
//    }
//
//    /**
//     * 注意：
//     * 【@GetMapping("/depts")】<--- 这个注解不能重复出现。改成，后面家【/{id}】
//     * 而且，配套加【@PathVariable】注解
//     * @param id
//     * @return
//     */
//    @GetMapping("/depts/{id}")
//    public Result getDeptById(@PathVariable Integer id) {
//        System.out.println("Id====================="+id);
//        String name= deptService.getDeptByIs(id);
//        System.out.println("Id====================="+name);
//        return Result.success(name);
//    }
//
//
//    @PutMapping("/depts")
//    public Result update(@RequestBody dept dept) {
//        System.out.println(dept);
//        deptService.updateName(dept);
//        return Result.success();
//
//    }
}
