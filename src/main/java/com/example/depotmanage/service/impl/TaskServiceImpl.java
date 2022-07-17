package com.example.depotmanage.service.impl;

import com.example.depotmanage.entity.Task;
import com.example.depotmanage.mapper.TaskMapper;
import com.example.depotmanage.service.ITaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dzy
 * @since 2022-05-05
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements ITaskService {

}
