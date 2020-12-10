<#include "base/header.ftl">

<div class="ui middle aligned center aligned grid" style="height: 100%">
    <div class="column" style="max-width: 500px">
        <h2 class="ui teal header">Health App CMS</h2>

        <form class="ui large form" method="POST" action="/login">
            <div class="ui stacked segment">

                <div class="field">
                    <div class="ui left icon input">
                        <i class="user icon"></i>
                        <input id="username" type="text" name="username" placeholder="Username">
                    </div>
                </div>

                <div class="field">
                    <div class="ui left icon input">
                        <i class="lock icon"></i>
                        <input id="password" type="password" name="password" placeholder="Password">
                    </div>
                </div>
                <div class="ui fluid large submit button">Login</div>
            </div>
        </form>

    </div>
</div>

<#include "base/footer.ftl">