package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import com.example.demo.entity.OutputData;
import com.example.demo.service.IOutputDataService;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wyc
 * @since 2022-04-24
 */
@RestController
@RequestMapping("/output-data")
        public class OutputDataController {
            @Resource
        private IOutputDataService outputDataService;

        @PostMapping
        public Boolean save(@RequestBody OutputData outputData) {
            return outputDataService.saveOrUpdate(outputData);
        }

        @DeleteMapping("/{id}")
        public Boolean delete(@PathVariable Integer id) {
            return outputDataService.removeById(id);
        }

@PostMapping("/delete/batch")
public boolean deleteUserByIdBatch(@RequestBody List<Integer> ids) {
        return outputDataService.removeBatchByIds(ids);
        }

        @GetMapping
        public List<OutputData> findAll() {
            return outputDataService.list();
        }

        @GetMapping("/{id}")
        public OutputData findOne(@PathVariable Integer id) {
            return outputDataService.getById(id);
        }

        @GetMapping("/page")
        public Page<OutputData> findPage(@RequestParam Integer pageNum,
        @RequestParam Integer pageSize) {
        IPage<User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
            return outputDataService.page(new Page<>(pageNum, pageSize));
        }
    }

