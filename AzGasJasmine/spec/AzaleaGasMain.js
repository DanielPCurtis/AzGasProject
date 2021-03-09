describe("Azalea Gas Testing Suite", () =>  {
    describe("Azalea Gas Test for main.js", () =>   {
        beforeEach( (done) =>   {
            const fixture = document.getElementById('fixture');

            const italic = document.createElement('i');
            italic.className = 'fas fa-bars pulse';
            italic.onClick = 'showHideMenu()';

            const yr = document.createElement('span');
            yr.id = 'copyYear';

            const navUl = document.createElement('ul');
            navUl.className = 'page-links retract';

            const content = document.createElement('div');
            content.id = "content";
            content.className = "no-page";

            const aTag = document.createElement('A');
            aTag.className = 'testy';

            const qLink = document.createElement('div');
            qLink.id = "quick-links";

            //Nav Stuff
            const liHom = document.createElement('li');
            liHom.className = 'home';
            const aLiHom = document.createElement('a'); 
            liHom.appendChild(aLiHom);
            const liSys = document.createElement('li');
            liSys.className = 'systems';
            const aLiSys = document.createElement('a'); 
            liSys.appendChild(aLiSys);
            const liFir = document.createElement('li');
            liFir.className = 'fireplace';
            const aLiFir = document.createElement('a'); 
            liFir.appendChild(aLiFir);
            const liIns = document.createElement('li');
            liIns.className = 'instruct';
            const aLiIns = document.createElement('a'); 
            liIns.appendChild(aLiIns);
            const liQue = document.createElement('li');
            liQue.className = 'questions';
            const aLiQue = document.createElement('a'); 
            liQue.appendChild(aLiQue);
            const liSpe = document.createElement('li');
            liSpe.className = 'quick-links';
            const aLiSpe = document.createElement('a'); 
            liSpe.appendChild(aLiSpe);

            const aHom = document.createElement('a');   
            aHom.className = 'home';
            const aSys = document.createElement('a');
            aSys.className = 'systems';
            const aFir = document.createElement('a');
            aFir.className = 'fireplace';
            const aIns = document.createElement('a');
            aIns.className = 'instruct';
            const aQue = document.createElement('a');
            aQue.className = 'questions';
            const aSpe = document.createElement('a');
            aSpe.className = 'quick-links';

            const pgNav = document.createElement('div');
            pgNav.className = 'page-nav';

            pgNav.appendChild(liHom);   
            pgNav.appendChild(liSys);            
            pgNav.appendChild(liFir);            
            pgNav.appendChild(liIns);            
            pgNav.appendChild(liQue);            
            pgNav.appendChild(liSpe);

            const ulMap = document.createElement('ul');

            ulMap.appendChild(aHom);   
            ulMap.appendChild(aSys);            
            ulMap.appendChild(aFir);            
            ulMap.appendChild(aIns);            
            ulMap.appendChild(aQue);            
            ulMap.appendChild(aSpe);

            const siteMap = document.createElement('div');
            siteMap.className = 'footer-siteMap';
            siteMap.appendChild(ulMap);

            //// End Nav Stuff

            fixture.appendChild(italic);
            fixture.appendChild(content);
            fixture.appendChild(yr);
            fixture.appendChild(navUl);
            fixture.appendChild(aTag);
            fixture.appendChild(qLink);
            fixture.appendChild(pgNav);
            fixture.appendChild(siteMap);

            done();
           
        });
        it("should test the return value when getHamburgerBtn is called", () =>    { 
            const obj = document.getElementsByClassName( 'fa-bars' )[0];
            expect( getHamburgerBtn() ).toEqual( obj );
        });
        it("should test getHamburgerBtn is called when hamburgerSeen is called", () =>  {
            const spy = spyOn(window, 'getHamburgerBtn').and.callThrough();
            window.hamburgerSeen();
            expect( spy ).toHaveBeenCalledTimes(1);
        });
        it("should test the return value when getNavUl is called", () =>    {
            const obj = document.getElementsByClassName( 'page-links ' )[0];
            expect( getNavUl() ).toEqual( obj );
        });
        it("should test getNavUl is called when showHideMenu is called", () =>  {
            const spy = spyOn(window, 'getNavUl' ).and.callThrough();
            window.showHideMenu();
            expect(spy).toHaveBeenCalledTimes(1);
        });
        it("should test getHamburgerBtn is called when showHideMenu is called", () =>  {
            const spy = spyOn(window, 'getHamburgerBtn' ).and.callThrough();
            window.showHideMenu();
            expect(spy).toHaveBeenCalledTimes(1);
        });
        it("should test getNavUl className is modified after showHideMenu is called", () =>  {
            const obj = document.getElementsByClassName( 'page-links ' )[0];
            expect(obj.className).toBe('page-links retract');
            showHideMenu();
            expect(obj.className).toBe('page-links expand');
        });
        it("should test getNavUl className is added when none is included after showHideMenu is called", () =>  {
            const obj = document.getElementsByClassName( 'page-links ' )[0];
            obj.className = 'page-links';
            expect(obj.className).toBe('page-links');
            showHideMenu();
            expect(obj.className).toBe('page-links retract');
        });
        it("should test getNavUl className is modified after showHideMenu is called", () =>  {
            const obj = document.getElementsByClassName( 'page-links ' )[0];
            obj.className = 'page-links expand';
            expect(obj.className).toBe('page-links expand');
            showHideMenu();
            expect(obj.className).toBe('page-links retract');
        });
        it("should test hideMenu modifies the className when expand is passed in", () =>    {
            const obj = document.getElementsByClassName( 'page-links ' )[0];
            obj.className = 'page-links expand';
            expect(obj.className).toBe('page-links expand');
            hideMenu();
            expect(obj.className).toBe('page-links retract');
        });
        it("should test hideMenu modifies the className when a blank is passed in", () =>    {
            const obj = document.getElementsByClassName( 'page-links ' )[0];
            obj.className = 'page-links';
            expect(obj.className).toBe('page-links');
            hideMenu();
            expect(obj.className).toBe('page-links retract');
        });
        it("should test hideMenu modifies the className when retract is passed in", () =>    {
            const obj = document.getElementsByClassName( 'page-links ' )[0];
            expect(obj.className).toBe('page-links retract');
            hideMenu();
            expect(obj.className).toBe('page-links retract');
        });
        it("should test the return value when getTtileFromPage is called", () =>    {
            const title = 'quick-links';
            expect( getTtileFromPage(title) ).toBe( 'Speed Links' );
        });
        it("should test the return value when getTtileFromPage is called", () =>    {
            const title = 'home';
            expect( getTtileFromPage(title) ).toBe( 'Home' );
        });
        it("should test the return value when getTtileFromPage is called", () =>    {
            const title = 'systems';
            expect( getTtileFromPage(title) ).toBe( 'Tank Systems' );
        });
        it("should test the return value when getTtileFromPage is called", () =>    {
            const title = 'fireplace';
            expect( getTtileFromPage(title) ).toBe( 'Fireplace Sets' );
        });
        it("should test the return value when getTtileFromPage is called", () =>    {
            const title = 'instruct';
            expect( getTtileFromPage(title) ).toBe( 'Instructions' );
        });
        it("should test the return value when getTtileFromPage is called", () =>    {
            const title = 'questions';
            expect( getTtileFromPage(title) ).toBe( 'Q & A' );
        });
        it("should test the return value when getTtileFromPage is called", () =>    {
            const title = 'bad value';
            expect( getTtileFromPage(title) ).toBe( 'Home' );
        });
        it("should test setTitle", () =>    {
            const title = 'home';
            setTitle(title);
            const obj = document.head.getElementsByTagName( 'title' )[0].innerHTML;
            const ans = 'Home';
            expect( obj ).toBe('Azalea Gas: ' + ans);
            document.head.getElementsByTagName( 'title' )[0].innerHTML = '';
        });
        it("should test setTitle", () =>    {
            const title = 'systems';
            setTitle(title);
            const obj = document.head.getElementsByTagName( 'title' )[0].innerHTML;
            const ans = 'Tank Systems';
            expect( obj ).toBe('Azalea Gas: ' + ans);
            document.head.getElementsByTagName( 'title' )[0].innerHTML = '';
        });
        it("should test setTitle", () =>    {
            const title = 'instruct';
            setTitle(title);
            const obj = document.head.getElementsByTagName( 'title' )[0].innerHTML;
            const ans = 'Instructions';
            expect( obj ).toBe('Azalea Gas: ' + ans);
            document.head.getElementsByTagName( 'title' )[0].innerHTML = '';
        });
        it("should test getTtileFromPage is called when setTitle is called", () =>  {
            const spy = spyOn( window, 'getTtileFromPage' ).and.callThrough();
            const title = 'home';
            setTitle(title);
            expect(spy).toHaveBeenCalledTimes(1);
            document.head.getElementsByTagName( 'title' )[0].innerHTML = '';
        });
        it("should test the className is modified when showPage is called", () =>    {
            const page = 'home';
            const obj = document.getElementById( 'content' );
            showPage( page, 0 );
            expect(obj.className).toBe( page );
        });
        it("should verify hideMenu, setTitle is called when showPage is called", () =>    {
            const spy = spyOn( window, 'hideMenu').and.callThrough();
            const spy2 = spyOn(window, 'setTitle').and.callThrough();
            const page = 'home';
            const obj = document.getElementById( 'content' );
            obj.className = page;
            showPage( page, 1 );
            expect(spy).toHaveBeenCalledTimes(1);
            expect(spy2).toHaveBeenCalledTimes(1);
            expect(spy2).toHaveBeenCalledWith(page);
        });
        it("should verify showHideMenu, setTitle is called when showPage is called", () =>    {
            const spy = spyOn( window, 'showHideMenu').and.callThrough();
            const spy2 = spyOn(window, 'setTitle').and.callThrough();
            const page = 'home';
            const obj = document.getElementById( 'content' );
            obj.className = page;
            showPage( page, 0 );
            expect(spy).toHaveBeenCalledTimes(1);
            expect(spy2).toHaveBeenCalledTimes(1);
            expect(spy2).toHaveBeenCalledWith(page);
        });
        it("should test crntPage is set by page when setInitialPage is called", () =>    {
            //location.href = 'http://localhost/jasmine-standalone-3.6.0/SpecRunner.html#home'
            const spy = spyOn(window, 'showPage');
            const pg = 'home';
            setInitialPage();
            expect(spy).toHaveBeenCalledTimes(1);
            expect(spy).toHaveBeenCalledWith(pg, 1);
        });
        xit("should test crntPage is set to home when quicklinks given when setInitialPage is called", () =>    {
            var href = location.href.split('#')[0];
            location.href += '#quick-links';
            const spy = spyOn(window, 'showPage');
            const pg = 'home';
            setInitialPage();
            expect(spy).toHaveBeenCalledTimes(1);
            expect(spy).toHaveBeenCalledWith(pg, 1);
        });
        it("should test that addClickEvent is called 11 TIMES! when defineClick is called", () => {
            const spy = spyOn( window, 'addClickEvent' );
            defineClick();
            expect(spy).toHaveBeenCalledTimes(11);
        });
        it("should test when addClickEvent is called", () =>    {
            const a = document.getElementsByClassName('testy')[0];
            const spy = spyOn(window, 'pushHistoryState').and.returnValue(true);
            const spy2 = spyOn(window, 'showPage').and.callThrough();
            const val1 = 'home';
            addClickEvent( a, val1, 1);
            a.click();
            expect(spy).toHaveBeenCalledTimes(1);
            expect(spy2).toHaveBeenCalledTimes(1);
            expect(spy2).toHaveBeenCalledWith(val1, 1);
        });
        it("should test setQuickLinksMinHeight", () =>    {
            const div = document.getElementById('quick-links');
            const ans = '657px';
            setQuickLinksMinHeight();
            expect(div.style.minHeight).toBe(ans);
        });
        it("should test setCopyYear", () => {
            const year = document.getElementById('copyYear');
            const date = new Date().getFullYear();
            setCopyYear();
            expect( year.innerHTML ).toBe( date.toString() );
        });
        it("should test that setCopyYear is called when init is called", () =>   {
            const spy = spyOn( window, 'setCopyYear' );
            init();
            expect(spy).toHaveBeenCalledTimes(1);
        });
        it("should test that setQuickLinksMinHeight is called when init is called", () =>    {
            const spy = spyOn( window, 'setQuickLinksMinHeight' );
            init();
            expect(spy).toHaveBeenCalledTimes(1);
        });
        it("should test that setInitialPage is called when init is called", () =>    {
            const spy = spyOn( window, 'setInitialPage' );
            init();
            expect(spy).toHaveBeenCalledTimes(1);
        });
        it("should test that  defineClick is called when init is called", () =>   {
            const spy = spyOn( window, 'defineClick' );
            init();
            expect(spy).toHaveBeenCalledTimes(1);
        });
        

        afterEach( () =>    {
            document.getElementById('fixture').innerHTML = '';
            
        });
    });
})