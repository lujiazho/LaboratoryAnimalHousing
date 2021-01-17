import animal_info_datatable from '../datatable/animal-info-datatable.js';
import task_datatable from '../datatable/task-datatable.js';
import feed_formula_form from '../form/feed-formula-form.js';
import feeding_plan_form from '../form/feeding-plan-form.js';
import animal_details from '../panel/animal-details.js';
import feed_formula_datatable from '../datatable/feed-formula-datatable.js';
import common_page from './common-page.js';

! async function () {
    const element = layui.element;
    await common_page.init('福利喂养系统');
    let config = {animalNumber:''};
    const functions = [
        ()=>animal_info_datatable.init(d=>animal_details.render(d,{
            feeding_plan_task_btn:true
        })),
        ()=>task_datatable.init(d=>animal_details.render(d, {
            feeding_plan_btn:d=>{
                config.animalNumber = d;
                element.tabChange('tab', 'feeding-plan');
            }
        })),
        ()=>{
            feeding_plan_form.init(config, feed_formula_datatable.init, animal_details.render);
            config.animalNumber = '';
        },
        ()=>feed_formula_form.init()]
    // 切换TAB感知以及刷新
    functions[0]();
    element.on('tab', function(data){
        functions[data.index]();
    });
}()
