package majiang.comunity.controller;

import majiang.comunity.dto.CommentCreateDTO;
import majiang.comunity.dto.CommentDTO;
import majiang.comunity.dto.ResultDTO;
import majiang.comunity.enums.CommentTypeEnum;
import majiang.comunity.exception.CustomizeErrorCode;
import majiang.comunity.model.Comment;
import majiang.comunity.model.User;
import majiang.comunity.service.CommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by lenovo on 2020/3/12.
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 添加一级评论功能（回复）
     * 先将获取页面传的json数据转为对象
     */
    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentCreateDTO commentCreateDTO,
                       HttpServletRequest request){

        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }

        if(commentCreateDTO == null || StringUtils.isBlank(commentCreateDTO.getContent())){
            return ResultDTO.errorOf(CustomizeErrorCode.COMMENT_IS_EMPTY);
        }

        Comment comment = new Comment();
        comment.setParentId(commentCreateDTO.getParentId());
        comment.setContent(commentCreateDTO.getContent());
        comment.setType(commentCreateDTO.getType());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setCommentator(user.getId());
        comment.setLikeCount(0L);
        commentService.insert(comment, user);
        return ResultDTO.okOf();
    }

    /**
     * 二级评论
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    public ResultDTO<List> comments(@PathVariable(name = "id") Long id){
        List<CommentDTO> commentDTOs = commentService.listByTargetId(id, CommentTypeEnum.CONTENT);
        return ResultDTO.okOf(commentDTOs);
    }
}
