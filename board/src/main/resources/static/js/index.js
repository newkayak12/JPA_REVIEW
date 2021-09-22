$(function(){
	$("#userPassword").keyup((e)=>{
		if(e.keyCode == 13){
			signin();
		}
	})
})

function signin(){
	
	let userId = document.getElementById("userId").value;
	let userPassword = document.getElementById("userPassword").value;
	if(userId.length!=0&&userPassword.length!=0){
		let data = {
			"userId":userId,
			"userPassword":userPassword,
		};

		$.ajax({
			type:"GET",
			url:"/api/v1/signin/"+userId+"/"+userPassword,
			// dateType:"json",
			// contentType:"application/json; charset=utf-8",
			// data:JSON.stringify(data),
			success:success_data=>{
			// let unsting = JSON.parse(success_data)
			if(success_data==1){
				alert("sign in success!")
				location.assign("/goto/main?userId="+userId)


			}
			// console.log(unsting)
			// 	alert(unsting);
			},
			error:error_data=>{
				console.log(error_data)
				alert(error_data);
			}

		})
	}
}

function showDetail(boardNumber){
	location.assign("/api/v1/board/"+boardNumber);
}

function updateBoard(){
	let data = {
		boardNumber:document.getElementById("boardNumber").value,
		title:document.getElementById("title").value,
		userNickname:document.getElementById("userNickname").value,
		content:document.getElementById("content").value
	}
	$.ajax({
		type:"PUT",
		url:"/api/v1/board",
		dataType:"json",
		contentType:"application/json; charset=utf-8",
		data: JSON.stringify(data),
		success:success_data=>{
			if(success_data==1){
				window.location.assign('/goto/main');
			}
		},
		error:error_data=>{
			alert('수정에 실패했습니다.')
		}
	})

}

function deleteBoard(){
	let boardNumber = document.getElementById("boardNumber").value;
	$.ajax({
		type:"DELETE",
		url:"/api/v1/board/"+boardNumber,
		success:success_data=>{
			if(success_data==0){
				alert('글이 삭제되었습니다.')
				window.location.assign('/goto/main');
			}
		},
		error:error_data=>{
			alert('삭제에 실패했습니다.')
		}
	})
}

function writeBoard(){
	location.assign("/goto/writeForm")
}
function saveBoard(){
	let data ={
		title:document.getElementById("title").value,
		userNickname:document.getElementById("userNickname").value,
		content:document.getElementById("content").value
	}
	$.ajax({
		type:"POST",
		url:"/api/v1/board",
		dataType:"json",
		contentType:"application/json; charset=utf-8",
		data:JSON.stringify(data),
		success:success_data=>{
			console.log(success_data)
			if(success_data==1){
				alert("게시물 등록에 성공했습니다.")
				 location.assign("/goto/main")
			}
		},
		error:error_data=>{
			alert("게시물을 등록에 실패했습니다.")
			console.log(error_data)
		}
	})

}

function signupForm(){
	location.assign("/goto/sinupForm")
}