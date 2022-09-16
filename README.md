# Board

## Error Records
<details markdown="1">
<summary> 게시글 작성 테스트 코드 오류 </summary>  

### ✅ 문제상황  

해당 부분에서 에러 발생  
![image](https://users-images.githubusercontent.com/73023890/184631206-6064b0f1-3000-4f77-8fd4-ee0fb8c4ef3c.png)  
![image](https://users-images.githubusercontent.com/73023890/184632136-23faf494-a3b1-4d73-9432-735c5c89a857.png)  
![image](https://users-images.githubusercontent.com/73023890/184632178-0638ad3a-da7e-4fe2-87f5-16bbc459f122.png)  
![image](https://users-images.githubusercontent.com/73023890/184632231-9ab81955-5ff5-4520-b23e-689599c8f659.png)



> ResponseEntity response에 body 부분이 담기지 않아 생기는 오류  
> response 내부를 본 결과 status code, header은 잘 나오지만 body가 나오지 않음  
> 확인 결과 controller, service에서 저장한 데이터를 return 하지 않아 발생하는 오류

### ✅ 해결방안

> controller, service에 게시글을 저장하는 메서드를 void에서 Post를 return 하도록 변경  
> ![image](https://users-images.githubusercontent.com/73023890/184632996-4e4c5404-9fc3-4b3c-8648-101e5af4c4d5.png) ![image](https://users-images.githubusercontent.com/73023890/184633015-b7c9a120-d398-497f-ab32-21969efd0a8d.png)  
> ![image](https://users-images.githubusercontent.com/73023890/184633130-312c1684-155d-45eb-8b17-bd56c5a262f3.png) ![image](https://users-images.githubusercontent.com/73023890/184633188-a176f1ad-2702-49fc-9e0b-cd7b4bf70abf.png)


### ✅ 결과

> 정상적으로 작동

