/**
 * 功能：分页页码设置公共 js 文件, 需要分页的html引入了jQuery之后，引入本js到html页面中
 * 使用要求： 
 * 1- 页面需要定义一个无序列表且id="pagination" 分页容器
 * 2- html页面需要定义一个公共的 pageVO 对象放置分页信息: var pageVO = null;
 * 3- html页面需要定义显示表格数据的方法：
  function showTableInfo(){
      //清空之前的数据
  		$("tbody").empty();

  		//遍历当前页的数据
  		for(let item of pageVO.content){
  			//拼接表格行
  		let row = `
  			<tr>
  			  <td>${...}</td>
  			  <td>
  			    <div class="btn-group">
  			      <a class="btn btn-xs btn-default"
  					href="javascript:jumpModPro(${pro.proId}, '${pro.proName}', '${pro.proDesc}', ${pro.proPrice}, ${pro.productType.typeId})"
  					title="编辑" data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>
  			      <a class="btn btn-xs btn-default" href="javascript:delPro(${pro.proId}, '${pro.proName}')" title="删除" data-toggle="tooltip"><i class="mdi mdi-window-close"></i></a>
  			    </div>
  			  </td>
  			</tr>
  		`;
  		//添加到表格中
  		$("tbody").append(row);
		}
  }
 * 4- 在页面内容加载完毕后调用方法： loadPageInfo(请求地址)
 *
 * 删除方法调用：如果需要根据id删除信息, 则调用方法： delById(删除地址, 删除id, 删除对象的名称提示信息)
 *
 *
 */

/**
 * 获取分页类别信息
 */
function loadPageInfo(url, page, size){
	//如果没有传递page信息则默认为第一页
	if(!page){
		page = 1;
	}
	//如果没有传size信息，默认为5条
	if(!size){
		size = 5;
	}
	
	//封装查询参数
	let param = {
		"page": page,
		"size": size
	}
	
	//分页信息请求
	$.getJSON(url, param, 
		function(returnVO){
			console.log("queryByPage: ", returnVO);
			//请求出错
			if(returnVO.code != 1){
				lightyear.notify(returnVO.msg, "danger", 5000);
				return;
			}
			
			//请求成功, 记录当前页信息
			pageVO = returnVO.content;
			//给全局页面对象捆绑请求地址
			pageVO.url = url;
			
			//显示信息
			showTableInfo();
			//显示分页
			setPagination();
	});
	
	
}

/**
	 * 设置分页页码
	 */
	function setPagination(){
		//清理已有的分页标签
		$("#pagination").empty();
		
		//拼接分页信息
		let pageEle = `
			<li class="${pageVO.pageable.pageNumber == 0? 'disable' : ''}"><a href="javascript:jumpPrePage()">«</a></li>
		`;
		
		//循环页码
		for(let i = 1; i<= pageVO.totalPages; i++){
			pageEle += `
				<li  class="${pageVO.pageable.pageNumber == i - 1? 'active' : ''}"><a href="javascript:jumpIndexPage(${i})">${i}</a></li>
			`;
		}
		//添加向后一页
		pageEle += `
			<li class="${pageVO.pageable.pageNumber == pageVO.totalPages - 1? 'disable' : ''}"><a href="javascript:jumpNextPage()">»</a></li>
		`;
		
		//添加到分页容器
		$("#pagination").append(pageEle);
	}
	
	/**
	 * 跳转到上一页
	 */
	function jumpPrePage(){
		loadPageInfo(pageVO.url, pageVO.pageable.pageNumber, pageVO.pageable.pageSize);
	}
	
	/**
	 * 跳转到下一页
	 */
	function jumpNextPage(){
		loadPageInfo(pageVO.url, pageVO.pageable.pageNumber+2, pageVO.pageable.pageSize);
	}
	
	/**
	 * 跳转到指定页
	 */
	function jumpIndexPage(i){
		loadPageInfo(pageVO.url, i, pageVO.pageable.pageSize);
	}

/**
 * 根据id删除
 */
function delById(url, id, delMsg){
	$.alert({
		title: '删除',
		content: `是否真的删除： <br> <strong>${delMsg}</strong> `,
		buttons: {
			confirm: {
				text: '确认',
				btnClass: 'btn-primary',
				action: function(){
					$.getJSON(url+id, function (rvo){
						console.log("delById: ", rvo);
						if(rvo.code != 1){
							lightyear.notify(rvo.msg, "danger", 1000);
							return;
						}


						//删除成功，跳转到本页
						loadPageInfo(pageVO.url, pageVO.pageable.pageNumber + 1, pageVO.pageable.pageSize);
					});
				}
			},
			cancel: {
				text: '取消',
				action: function () {

				}
			}
		}
	});

}