import { HomePage, TasksPage, TipogrupoPage, ProfilePage, GroupsPage, PersonsPage } from './pages';
import { withNavigationWatcher } from './contexts/navigation';

const routes = [

    {
        path: '/persons',
        element: PersonsPage
    },
    {
        path: "/groups",
        element: GroupsPage
    },
    {
        path: '/tasks',
        element: TasksPage
    },
    {
        path: '/profile',
        element: ProfilePage
    },
    {
        path: '/home',
        element: HomePage
    },
    {
        path: '/tipogrupo',
        element: TipogrupoPage
    }
    
];

export default routes.map(route => {
    return {
        ...route,
        element: withNavigationWatcher(route.element, route.path)
    };
});
