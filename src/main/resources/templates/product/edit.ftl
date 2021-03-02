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
                    <label>Manufacturer ID</label>
                    <input type="text" name="manufacturerId" placeholder="Manufacturer ID">
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
                    <input type="text" name="imageUrl" placeholder="Image URL">
                </div>

            </div>
        </div>

        <div class="ui button" >Enter</div>
    </form>
</div>

<#include "../base/footer.ftl">