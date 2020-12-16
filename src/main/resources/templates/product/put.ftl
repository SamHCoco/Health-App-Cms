<#include "../base/header.ftl">

<div class="ui container" style="max-width: 80%; margin-top: 10px">
    <form class="ui form">

        <h4 class="ui dividing header">Products</h4>

        <div class="field">
            <div class="three fields">
                <div class="six wide field">
                    <label>Name</label>
                    <input type="text" name="name" placeholder="Name">
                </div>

                <div class="six wide field">
                    <label>Manufacturer</label>
                    <input type="text" name="manufacturer" placeholder="Manufacturer">
                </div>

                <div class="four wide field">
                    <label>Price</label>
                    <input type="text" name="price" placeholder="Price (£)">
                </div>
            </div>
        </div>

        <div class="field">
            <label>Description</label>
            <textarea type="text" name="description" placeholder="Description" rows="4"></textarea>
        </div>

        <div class="ui button" >Enter</div>
    </form>
</div>

<#include "../base/footer.ftl">