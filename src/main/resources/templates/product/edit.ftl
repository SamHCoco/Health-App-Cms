<#include "../base/header.ftl">

<div class="ui container" style="max-width: 80%; margin-top: 10px">
    <form class="ui form" method="POST" action="/product/create">

        <h4 class="ui dividing header">Products</h4>

        <div class="ui cards">

            <div class="card">
                <div class="image">
                    <img src="/static/img/test-jpg.jpg" alt="Not found">
                </div>

                <div class="content">
                    <a header="header">Aspirin - Boots</a>
                    <div class="meta">£5.99</div>
                </div>
            </div>

        </div>

        <div class="field">
            <div class="four fields">
                <div class="three wide field">
                    <label>ID</label>
                    <input type="text" name="id" placeholder="ID" value="${product.id!''}">
                </div>


                <div class="six wide field">
                    <label>Name</label>
                    <input type="text" name="name" placeholder="Name" value="${product.name!''}">
                </div>

                <div class="three wide field">
                    <label>Manufacturer ID</label>
                    <input type="text" name="manufacturerId" placeholder="Manufacturer ID" value="${product.manufacturerId!''}">
                </div>

                <div class="four wide field">
                    <label>Price</label>
                    <input type="text" name="price" placeholder="Price (£)" value="${product.price!''}">
                </div>
            </div>
        </div>

        <div class="field">
            <label>Description</label>
            <textarea type="text" name="description" placeholder="Description" rows="4">${product.description!''}</textarea>
        </div>

        <div class="field">
            <div class="two fields">

                <div class="field">
                    <label>Category</label>
                    <select class="ui fluid dropdown">
                        <option value="">Prescription</option>
                        <option value="AL">Pain</option>
                        <option value="AK">Eye care</option>
                        <option value="AK">Allergy & Hay fever</option>
                        <option value="AL">Cough, Cold & Flu</option>
                        <option value="AL">Sleep</option>
                        <option value="AL">Diabetes</option>
                    </select>
                </div>

                <div class="field">
                    <label>Image URL</label>
                    <input type="text" name="imageUrl" placeholder="Image URL" value="${product.imageUrl!''}">
                </div>

            </div>
        </div>

        <button class="ui button" type="submit">Enter</button>
    </form>
</div>

<#include "../base/footer.ftl">