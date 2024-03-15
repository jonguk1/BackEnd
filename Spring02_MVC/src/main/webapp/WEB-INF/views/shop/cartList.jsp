<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2 class="text-center text-secondary">
         a [id]  님의 장바구니
    </h2>
    <br><br>
    <div>
    <!-- 주문폼 시작------------------------------- -->
    <form name="orderF" action="orderAdd" method="post">
        <table class="table table-striped">
                <thead>
                    <tr>
                        <th>상품번호</th>
                        <th>상품명</th>
                        <th>수량</th>
                        <th>단가</th>
                        <th>금액</th>
                        <th>삭제</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- --------------------------- -->
                
                        <tr>
                            <td colspan="6">
                                <b>장바구니에 담긴 상품이 없습니다</b>
                            </td>
                        </tr>
                        
                            <tr>
                                <td>
                                <label>
                                <input type="checkbox" name="pnum"
                                  value="a">
                                상품번호
                                </label>
                                </td>
                                <td>
                                <h4>a</h4>
                                <a href="../prodDetail?pnum=a" target="_blank">
                                <img src="../resources/product_images/a"
                                 class="img-fluid" style="width:140px">
                                </a>
                                </td>
                                <td>
                                
                                <input type="number" name="pqty" id="pqty"
                                 value="1" min="1" max="50">
                                <button type="button" class="btn btn-success"
                                 onClick="">수정</button>
                                </td>
                                <td>
                                <fmt:formatNumber value="1" pattern="###,###"/> 원<br>
                                <span class="badge badge-danger">a</span> POINT
                                </td>
                                <td>
                                <fmt:formatNumber value="1" pattern="###,###"/> 원<br>
                                <span class="badge badge-danger">a</span> POINT
                                </td>
                                <td>
                                <a href="#" onclick="">삭제</a>
                                </td>
                            </tr>
                        
                    <!-- --------------------------- -->
                    
                    <tr>
                        <td colspan="3">
                            <h5>장바구니 총액: <span class='text-danger'> 
                                <fmt:formatNumber value="${cartSum.cartTotalPrice}"  pattern="###,###" />
                            원</span></h5>
                            <h5>장바구니 총포인트: <span class='text-success'> 
                                <fmt:formatNumber value="${cartSum.cartTotalPoint}"  pattern="###,###" />
                            Point</span></h5>
                        </td>
                        <td colspan="3">
                            <button type="button" class="btn btn-outline-info" onclick="goOrder()">주문하기</button>              
                            <button type="button" class="btn btn-outline-danger" onclick="location.href='../index'">계속쇼핑</button>
                            <button type="button" class="btn btn-outline-success" onclick="cartDelAll()">장바구니 비우기</button>
                        </td>
                    </tr>
                </tbody>
            
            </table>
    </form>
    </div>
    <!-- 주문폼 끝------------------- -->
    
    <!-- 삭제 폼 -------------------- -->
    <form name="df" id="df" action="cartDel">
        <input type="hidden" name="cartNum">
    </form>       
    <!--수정 폼-----------------------  -->
    <form name="ef" id="ef" action="cartEdit">
        <input type="hidden" name="cartNum">
        <input type="hidden" name="pqty">
    </form>
    <!-- ------------------------------ -->
    
<script>
    function cartEdit(cnum, i){
        
    }//-------------------------------
    function cartDel(cnum){//특정 상품 삭제
        
    }//------------------------
    function cartDelAll(){//장바구니 모두 비우기
        let yn=confirm('정말 모두삭제할까요?')
        if(yn){
            location.href="cartDelAll";
        }
    }//---------------------------
</script>
