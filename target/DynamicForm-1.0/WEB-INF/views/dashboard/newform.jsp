<%-- 
    Document   : newform
    Created on : May 28, 2017, 4:50:54 PM
    Author     : LAKHE
--%>

<%@include file="../shared/header.jsp" %>
        <h1>Hello World!</h1>
    <h3 align="center">Create New Form</h3>
<c:if test="${param.success!=null}">
    <div style="color:green">Form successfully saved!</div>
</c:if>
<form method="post" action="${pageContext.request.contextPath}/dashboard/save">
    
    <div id="form-fixedtop">
        <div class="form-group">
            <label>Form Title:</label>
            <input type="text" name="formTitle" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Form Description</label>
            <textarea name="formDescription" class="form-control"></textarea>
        </div>
    </div>
    <div style="font-weight:bold">Choose Form Fields:</div>
    <table id="tbl-formfields" class="table vertical-align table-condensed" >
        <tr>
            <th>Field</th>
            <th>Input Type</th>
            <th>Action</th>
        </tr>
        <tbody id="tbody">
            <tr id="tr-formField">
                <!--<td>${fieldCount}</td>-->
                <td>
                    <select name="formFieldName[]" id="formFieldName">
                        <option value="">-------------------------------------</option>
                        <c:forEach var="ff" items="${FormFields}">
                            <option value="${ff.ffId}">${ff.ffName}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <select name="formOptionType[]" id="formOptionType">
                        <option value="">-------------------------------------</option>
                        <option value="text">Text</option>
                        <option value="textarea">Textarea</option>
                        <option value="select">Select Options (Dropdown)</option>
                        <option value="radio">Radio Buttons</option>
                        <option value="checkbox">Checkbox</option>
                    </select>
                </td>
                
                <td>
                    <a class="btn btn-danger" id="btn-removefield">
                                            <span class="glyphicon glyphicon-remove"></span> Remove field
                    </a>
                </td>
            </tr>
        </tbody>
    </table>
    <div>
        <button type="button" id="btn-addfield" class="btn btn-primary">
            <span class="glyphicon glyphicon-plus"></span> Add Field
        </button>
<!--        <button type="button" id="btn-addusers" class="btn btn-info">
            <span class="glyphicon glyphicon-user"></span> Add Users
        </button>-->
    </div>
<!--    <div id="block-addusers" class="form-group" style="display:none">
        <div id="block-showusers"></div>
        <br><input type="text" name="adduser" id="adduser" placeholder="Add Users..."/>
        <a href="${SITE_URL}/user/search" id="btn-adduser" class="btn btn-default">
            Add
        </a>
        <button type="button" id="btn-canceladduser" class="btn btn-link">Cancel</button>
    </div><br>-->
    <button type="button" id="btn-saveform" class="btn btn-success">
        <span class="glyphicon glyphicon-floppy-disk"></span> Save This Form
    </button>
</form>

<c:set var="fieldCount"  value="${fieldCount}" />
<script>
    
    $(document).on('ready', function () {
//        $("#btn-addusers").on('click', function () {
//            $("#block-addusers").show();
//            $("#btn-adduser").on('click', function (e) {
//                e.preventDefault();
//                $.post(this.href, function (data) {
//                    if (data !== null) {
//                        $("#block-showusers").html(data);
//                    }
//                });
//            });
//            $("#btn-canceladduser").on('click', function () {
//                $("#block-showusers").html("");
//                $("#adduser").val("");
//                $("#block-addusers").hide();
//            });
        });
        var repeatBlock = $("#tbody");
        var repeatText = '<tr id="tr-formField"><td><select name="formFieldName[]" id="formFieldName"><option value="">-------------------------------------</option><c:forEach var="ff" items="${FormFields}"><option value="${ff.ffId}">${ff.ffName}</option></c:forEach></select></td><td><select name="formOptionType[]" id="formOptionType"><option value="">-------------------------------------</option><option value="text">Text</option><option value="textarea">Textarea</option><option value="select">Select Options (Dropdown)</option><option value="radio">Radio Buttons</option><option value="checkbox">Checkbox</option></select></td><td><label><input type="checkbox" name="fieldRequired[]"/> Required</label></td><td><a href="#" class="removeField" id="btn-removefield" style="color:red" title="Remove this field"><span class="glyphicon glyphicon-remove"></span></a></td></tr>';
        $("#btn-addfield").click(function (e) {
            e.preventDefault();
            $(repeatBlock).append(repeatText);
    
        });
        $(repeatBlock).on('click', '.removeField', function (e) {
            e.preventDefault();
            $(this).parent().parent().remove();
        });

</script>
<%@include file="../shared/footer.jsp" %>