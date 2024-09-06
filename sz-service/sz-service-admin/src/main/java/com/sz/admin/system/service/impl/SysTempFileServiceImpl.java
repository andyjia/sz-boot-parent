package com.sz.admin.system.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.sz.admin.system.service.SysTempFileService;
import com.sz.admin.system.pojo.po.SysTempFile;
import com.sz.admin.system.mapper.SysTempFileMapper;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.query.QueryChain;
import com.sz.core.common.enums.CommonResponseEnum;
import com.sz.core.util.PageUtils;
import com.sz.core.util.BeanCopyUtils;
import com.sz.core.util.Utils;
import com.sz.core.common.entity.PageResult;
import com.sz.core.common.entity.SelectIdsDTO;
import java.io.Serializable;
import java.util.List;
import com.sz.admin.system.pojo.dto.systempfile.SysTempFileCreateDTO;
import com.sz.admin.system.pojo.dto.systempfile.SysTempFileUpdateDTO;
import com.sz.admin.system.pojo.dto.systempfile.SysTempFileListDTO;
import com.sz.admin.system.pojo.vo.systempflie.SysTempFileVO;

/**
 * <p>
 * 模版文件表 服务实现类
 * </p>
 *
 * @author sz-admin
 * @since 2024-09-05
 */
@Service
@RequiredArgsConstructor
public class SysTempFileServiceImpl extends ServiceImpl<SysTempFileMapper, SysTempFile> implements SysTempFileService {
    @Override
    public void create(SysTempFileCreateDTO dto){
        SysTempFile sysTempFile = BeanCopyUtils.copy(dto, SysTempFile.class);
        long count;
        // 唯一性校验
        count = QueryChain.of(SysTempFile.class).eq(SysTempFile::getPermissions, dto.getPermissions()).count();
        CommonResponseEnum.EXISTS.message("permissions已存在").assertTrue(count > 0);
        save(sysTempFile);
    }

    @Override
    public void update(SysTempFileUpdateDTO dto){
        SysTempFile sysTempFile = BeanCopyUtils.copy(dto, SysTempFile.class);
        QueryWrapper wrapper;
        // id有效性校验
        wrapper = QueryWrapper.create()
            .eq(SysTempFile::getId, dto.getId());
        CommonResponseEnum.INVALID_ID.assertTrue(count(wrapper) <= 0);

        // 唯一性校验
        long count;
        count = QueryChain.of(SysTempFile.class).eq(SysTempFile::getPermissions, dto.getPermissions()).ne(SysTempFile::getId, dto.getId()).count();
        CommonResponseEnum.EXISTS.message("permissions已存在").assertTrue(count > 0);
        saveOrUpdate(sysTempFile);
    }

    @Override
    public PageResult<SysTempFileVO> page(SysTempFileListDTO dto){
        Page<SysTempFileVO> page = pageAs(PageUtils.getPage(dto), buildQueryWrapper(dto), SysTempFileVO.class);
        return PageUtils.getPageResult(page);
    }

    @Override
    public List<SysTempFileVO> list(SysTempFileListDTO dto){
        return listAs(buildQueryWrapper(dto), SysTempFileVO.class);
    }

    @Override
    public void remove(SelectIdsDTO dto){
        CommonResponseEnum.INVALID_ID.assertTrue(dto.getIds().isEmpty());
        removeByIds(dto.getIds());
    }

    @Override
    public SysTempFileVO detail(Object id){
        SysTempFile sysTempFile = getById((Serializable) id);
        CommonResponseEnum.INVALID_ID.assertNull(sysTempFile);
        return BeanCopyUtils.copy(sysTempFile, SysTempFileVO.class);
    }

    private static QueryWrapper buildQueryWrapper(SysTempFileListDTO dto) {
        QueryWrapper wrapper = QueryWrapper.create().from(SysTempFile.class);
        if (Utils.isNotNull(dto.getName())) {
            wrapper.like(SysTempFile::getName, dto.getName());
        }
        if (Utils.isNotNull(dto.getPermissions())) {
            wrapper.like(SysTempFile::getPermissions, dto.getPermissions());
        }
        return wrapper;
    }
}